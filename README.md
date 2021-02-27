# EcommerceApp
 * It is an Ecommerce app which displays all the Products along with their details and can add those products to cart.
 
 # Teck stacks :
   
   * Android Tools : Android Studio
   * Android Components : Activities and Intents
   * Additional Components : RecycyclerView,Fragments,ViewPager and YoutubePlayerView
   * Architecture : MVVM(Architectural Components : Livadata,View Model)
   * Database : Roomdatase (Library)

# Screenshots and Description :
 
 * Splash Activity and SignUp Activity : 
    1. SignUpActivity to register the user details. 
    2. Here these user details are inserting into database and business logic separated from the UI
![splash(3)](https://user-images.githubusercontent.com/68853216/109376633-f8b21480-78eb-11eb-81ad-a9b91a440e28.png)
![signUP](https://user-images.githubusercontent.com/68853216/109376650-1da68780-78ec-11eb-98db-50c0a3a1321e.png)

 * LoginActivity and MAinACtivity :
   1. Login Activity here we Validating the user details based on Search query of database.
   2. MainActivity has a container to launch products fragment.It has a SearchView,
      NavigationDrawer and toolbar with actions.
   3. Products fragment displays the all the products in a recyclerview with price and along with
       listener to select a particular product.
   4. It displays Categories of products in a horizantal way in a recyclerview.

 ![login(2)](https://user-images.githubusercontent.com/68853216/109376700-52b2da00-78ec-11eb-9b8f-698204f6e003.png)
 ![allproducts](https://user-images.githubusercontent.com/68853216/109376708-6a8a5e00-78ec-11eb-963b-0292485428e2.png)

* DetailsActivity and SearchProducts :
  1.Details activity displays a particular product details along with 
    discription on click product on allproductsfragment.
  3.Based on product name we can search the products.

 ![details](https://user-images.githubusercontent.com/68853216/109376819-17fd7180-78ed-11eb-96a1-e7bb5e191fa4.png)
 ![search(1)](https://user-images.githubusercontent.com/68853216/109376894-804c5300-78ed-11eb-9c0a-c71277027f61.png)

* CartActivity and NavigationDrawer :
  1.We can add aprticular product to cart. 
  2.Navigation drawer with some items to perform specific operations.

![cart](https://user-images.githubusercontent.com/68853216/109376829-2ba8d800-78ed-11eb-91af-e3a35061cc41.png)
![navigation](https://user-images.githubusercontent.com/68853216/109376719-8130b500-78ec-11eb-9c48-489160a098c7.png)

* ProfileActivity :
  1. Onclick profile item in the Navigation Drawer we can navigate to this activity which displays the registered user details.
 ![profile](https://user-images.githubusercontent.com/68853216/109376723-9279c180-78ec-11eb-837a-219ae7098745.png)
