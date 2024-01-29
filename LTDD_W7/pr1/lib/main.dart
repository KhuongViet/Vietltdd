import 'package:flutter/material.dart';
// ignore: depend_on_referenced_packages
import 'package:http/http.dart' as http;
import 'dart:convert';

void main() {
  runApp(const MyApp());
}

class MyApp extends StatelessWidget {
  const MyApp({super.key});

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Ung dung tinh tong ',
      theme: ThemeData(
        colorScheme: ColorScheme.fromSeed(seedColor: Colors.deepPurple),
        useMaterial3: true,
      ),
      home: MyCal(), //goi den MyCal
    );
  }
}

class MyCal extends StatefulWidget {
  @override
  _MyCalState createState() {
    return _MyCalState();
  }
}

class _MyCalState extends State<MyCal> {
  TextEditingController numControl1 = TextEditingController(); //nhap so 1
  TextEditingController numControl2 = TextEditingController(); //nhap so 2
  //bien luu ket qua
  String kq = '';
  //viet ham tinh tong
  void tinhTong() {
    //lay gia tri tu 2 o nhap lieu
    double num1 = double.tryParse(numControl1.text) ?? 0.0;
    double num2 = double.tryParse(numControl2.text) ?? 0.0;
    double num = num1 + num2;
    //cap nhat trang thai
    setState(() {
      this.kq = 'Tong: $num';
    });
    //chuyen sang man hinh hien thi ket qua
    Navigator.push(
        context,
        MaterialPageRoute(
          builder: (context) => ResultScreen(kq),
        ));
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(title: Text('Ket qua')),
      body: Padding(
        padding: const EdgeInsets.all(8.0),
        child: Column(children: [
          TextField(
            controller: numControl1,
            keyboardType: TextInputType.number,
            decoration: InputDecoration(labelText: 'Nhap so 1'),
          ),
          TextField(
            controller: numControl2,
            keyboardType: TextInputType.number,
            decoration: InputDecoration(labelText: 'Nhap so 2'),
          ),
          SizedBox(height: 10),
          ElevatedButton(onPressed: tinhTong, child: Text('Tinh Tong')),
          SizedBox(height: 10),
        ]),
      ),
    );
  }
}

class ResultScreen extends StatelessWidget {
  final String result;
  ResultScreen(this.result);

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(title: Text('Ket qua tinh tong')),
      body: Center(child: Text(result,style: TextStyle(fontSize: 15,fontWeight: FontWeight.bold),)),
    );
  }
}
