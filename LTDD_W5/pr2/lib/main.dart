import 'package:flutter/material.dart';
import 'package:http/http.dart' as http;
import'dart:convert';

//b1-thiet ke class
class Product{
  String search_image;
  String styleid;
  String brands_filter_facet;
  String price;
  String product_additional_info;

  Product({
    required this.search_image,
    required this.styleid,
    required this.brands_filter_facet,
    required this.price,
    required this.product_additional_info
  }
  );
}

//Activity:
class ProductListScreen extends StatefulWidget{
  @override
  _ProductListScreenState createState() => _ProductListScreenState();
}


//b3-dedine activity: lay du lieu tu server ve
class _ProductListScreenState extends State<ProductListScreen>{
  late List<Product> products;

  //ham khoi tao
  @override
  void initState() {
    // TODO: implement initState
    super.initState();
    products = [];
    fetchProduct(); //ham lay du lieu tu server
  }  
  //ham doc du lieu tu server
  Future<void> fetchProduct() async {
    final response = await http.get(Uri.parse("http://192.168.1.54/aserver/get.php"));
    if(response.statusCode==200){
      final Map<String,dynamic > data=json.decode(response.body);
      setState(() {
        products=convertMaptoList(data);
      });
    }
    else
      {
        throw Exception("Khong doc duoc du lieu");
      }
  }
  
  // ham vonvert Map thanh List
  List<Product> convertMaptoList(Map<String,dynamic> data){
    List<Product> productList=[];//list rong
    data.forEach((key, value) {
      for(int i=0;i<value.length;i++){
        Product product=Product(
            search_image:value[i]['search_image']??'',
            styleid: value[i]['styleid']?? 0, 
            brands_filter_facet: value[i]['brands_filter_facet']??'', 
            price: value[i]['price']?? 0, 
            product_additional_info: value[i]['product_additional_info']??'');
        productList.add(product);
      }
    });
    return productList;
  }
  
  //Tao layout(~giong layout xml trong Android)
  
  @override
  Widget build(BuildContext context){
    return Scaffold(
      appBar: AppBar(
        title: Text("Danh sach san pham"),
      ),
      body: products !=null ?
      ListView.builder(
          itemCount: products.length,
          itemBuilder:(context,index){
              return ListTile(
                title: Text(products[index].brands_filter_facet),
                subtitle: Column(
                  crossAxisAlignment: CrossAxisAlignment.start,
                  children: [
                    Text('price:${products[index].price}'),
                    Text('product_additional_info:${products[index].product_additional_info}'),
                  ],
                ),
                leading: Image.network(
                  products[index].search_image,
                  width: 50,
                  height: 50  ,
                  fit: BoxFit.cover,
                ),
              );
          } 
      )
          :Center(
            child: CircularProgressIndicator(),
      )
    );
  }

}

//Android Manifest

void main() {
  runApp(const MyApp());
}

class MyApp extends StatelessWidget {
  const MyApp({super.key});

  // This widget is the root of your application.
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Danh sach san pham',
      theme: ThemeData(

        colorScheme: ColorScheme.fromSeed(seedColor: Colors.deepPurple),
        useMaterial3: true,
      ),
      home: ProductListScreen(),
    );
  }
}


