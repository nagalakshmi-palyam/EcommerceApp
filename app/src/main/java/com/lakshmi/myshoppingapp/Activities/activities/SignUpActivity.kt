package com.lakshmi.myshoppingapp.Activities.activities

import android.Manifest
import android.annotation.SuppressLint
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.lakshmi.myshoppingapp.Activities.SignUpViewModel.SignUpViewModel
import com.lakshmi.myshoppingapp.Activities.SignUpViewModel.SignUpViewModelFactory
import com.lakshmi.myshoppingapp.R
import kotlinx.android.synthetic.main.activity_sign_up.*
import java.io.FileNotFoundException

class SignUpActivity : AppCompatActivity() , View.OnClickListener{

    /**
     * This activity is used to insert the userDetails into the database using kotlin coroutines
     */

    private lateinit var signUpViewModel: SignUpViewModel
    private var profilePath:String="s"
    private val REQUEST_GET_SINGLE_FILE = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
        initViews()
    }
    fun initViews(){

        /*
       Here a viewmodelFactory is created since we need a context in the view model class
       to make a database insertion
        */
        signUpViewModel=SignUpViewModelFactory(this).create(SignUpViewModel::class.java)
        ivProfile.setOnClickListener(this)
        btnsignUp.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.btnsignUp->{
                //Inserting into databse
                if(isDataValid()) {
                    signUpViewModel.insertDetailstodatabase(
                        userName = etUserName.text.toString(),
                        mobileNumber=etPhoneNumber.text.toString(),
                        emailId = etEmail.text.toString(),
                        gender = etGender.text.toString(),
                        passWord = etPassword.text.toString(),
                        profileImage =profilePath

                    )
                    Toast.makeText(this@SignUpActivity, profilePath, Toast.LENGTH_SHORT).show()
                }
                val intent= Intent(this@SignUpActivity,LoginActivity::class.java)
                startActivity(intent)
                Toast.makeText(this@SignUpActivity,"User Successfully Registerd!", Toast.LENGTH_SHORT).show()
            }

            R.id.ivProfile->{
                if(isPermissionGranted()){
                    openGallery()
                } else{
                    requestStoragePermissions()
                }
            }
        }
    }

    /*
      Validating the Deatils
     */
    var mobile=10
    fun isDataValid() : Boolean{
        if (etUserName.text.toString().isEmpty()) {
            etUserName.error = "FirstName Can not be empty"
            return false
        }

        if (etPhoneNumber.text.toString().isEmpty()) {
            etPhoneNumber.error = "Phone Number can not be empty"
            return false
        } else if(etPhoneNumber.text.toString().length==mobile) {
            return true
        } else {
            etPhoneNumber.error = "Please Enter Valid Number"
        }

        if (etGender.text.toString().isEmpty()) {
            etGender.error = "gender cannot be empty"
            return false
        }
        if (etEmail.text.toString().isEmpty()) {
            etEmail.error = "Please Enter Email"
            return false
        }else if(etEmail.text.toString().contains("@")){
            return true
        }
        if(etPassword.text.toString().isEmpty()){
            etPassword.error="Password Should not be Empty"
            return false
        }
        return true

    }


    /*
      Open Gallery Via Intent
     */


    private fun openGallery() {
        val i = Intent(
            Intent.ACTION_PICK,
            MediaStore.Images.Media.EXTERNAL_CONTENT_URI
        )
        startActivityForResult(i, REQUEST_GET_SINGLE_FILE)
    }

    /*
    Request Storage Permissions
     */

    @SuppressLint("NewApi")
    private fun requestStoragePermissions() {
        requestPermissions(arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE), 2)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQUEST_GET_SINGLE_FILE && resultCode == RESULT_OK && null != data) {
            val selectedImage = data.data
            try {
                val imageStream = contentResolver.openInputStream(selectedImage!!)
                getPathFromURI(selectedImage)
            } catch (e: FileNotFoundException) {
                e.printStackTrace()
            }
        }
    }

    /*
    Getting Image path in the form String
     */

    private fun getPathFromURI(selectedImageUri: Uri): String? {
        val filePathColumn = arrayOf(MediaStore.Images.Media.DATA)
        val cursor = contentResolver.query(
            selectedImageUri,
            filePathColumn, null, null, null
        )
        cursor!!.moveToFirst()
        val columnIndex = cursor.getColumnIndex(filePathColumn[0])
        val picturePath = cursor.getString(columnIndex)
        cursor.close()
        Log.d("Lakshmi ", "Picture path $picturePath")
        profilePath=picturePath
        ivProfile.setImageURI(Uri.parse(picturePath))
        return picturePath
    }
    /*
    Checking is Permission to pic image Granted or not
     */
    private fun isPermissionGranted(): Boolean {
        return ContextCompat.checkSelfPermission(
            this@SignUpActivity,
            Manifest.permission.READ_EXTERNAL_STORAGE
        ) == PackageManager.PERMISSION_GRANTED
    }





}