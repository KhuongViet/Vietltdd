<?php
function ketNoiDB(){
    return new mysqli('localhost','root','','apr');
}
function themSanPhamDB($MaSP,$TenSP,$DVT,$DonGia,$NCC){
    $con=ketNoiDB();
    $i=$con->query('INSERT INTO sanpham 
    VALUES("'.$MaSP.'","'.$TenSP.'","'.$DVT.'","'.$DonGia.'","'.$NCC.'")');
    
    return $i;  
}

function hienThiSanPham(){
    $con=ketNoiDB();
    $result= $con->query('SELECT *FROM Sanpham');
    return $result;
}

function updateSanPhamDB($MaSP,$TenSP,$DVT,$DonGia,$NCC){
    $con=ketNoiDB();
    $i=$con->query('UPDATE sanpham SET TenSP=$TenSP,DVT=$DVT,
    DonGia=$DonGia,NCC=$NCC WHERE MaSP=$MaSP');
    return $i;
}