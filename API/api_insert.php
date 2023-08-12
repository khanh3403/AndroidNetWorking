<?php
$response=array();
//1.khai bao thong tin ket noi voi sql
$server="localhost";
$u="id20969813_khanh";
$p="Khanh342003@";
$db="id20969813_khanhbanda1";
//2.tao ket noi csdl
$conn=new mysqli($server,$u,$p,$db);
//2.1 kiem tra ket noi
if($conn->connect_error){
    die("ket noi loi".$conn->connect_error);//thong bao loi
}
//3.kiem tra du lieu vao api
if(isset($_GET['name'])&&isset($_GET['address'])&&isset($_GET['email'])){
    $name=$_GET['$name'];
    $address=$_GET['$address'];
    $email=$_GET['$email'];
    //4.insert du lieu
    $sql="INSERT INTO customer('name','address','email') VALUES('$name','$address','$email')";
    if($conn->query($sql)==TRUE){
        $response["success"]=1;
        $response["message"]="insert thanh cong";
        //chuyen du lieu sang json
        echo json_encode($response);
    }
    else{
        $response["success"]=0;
        $response["message"]="ERROR";
        //chuyen du lieu sang json
        echo json_encode($response);
    }
}
$conn->close();
?>