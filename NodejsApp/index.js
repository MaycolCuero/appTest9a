//1. Call mysql package
const mysql = require('mysql');

//2. Call express package
const express = require('express');

//3. Call body-parser package
const bodyparser = require('body-parser');

//4. Create a new express app isntance
var app = express();

//5. Enable JSON request 
app.use(bodyparser.json());

//6. Create mysql data base connection 
var connectionDB = mysql.createConnection({
    host: 'localhost',
    user:'root',
    password:'',
    database:'market'
});

//7. Valdiate mysql data base connection
connectionDB.connect((err)=>{
    if(!err) 
        console.log('::: Successfull data base connection :::');
    else
        console.log('DB connection failed \n Error: ' + JSON.stringify(err, undefined, 2));
});


//8.  RUN Server
app.listen(3000, ()=>console.log('Server is already running at port:3000'));

//9. GET all market data base users
app.get('/list_users',(req,res)=>{
    connectionDB.query('SELECT * FROM users',(err, rows, fields)=>{
        if(!err){
            console.log(rows);
            res.send(rows);
        }           
        else
            console.log(err);
    })
});

//10. GET/look for an user
app.get('/list_users/:id',(req,res)=>{
    connectionDB.query('SELECT * FROM users WHERE id=?', [req.params.id],(err, rows, fields)=>{
        if(!err){
            console.log(rows);
            res.send(rows);
        }           
        else
            console.log(err);
    })
});

//11. INSERT/UPDATE

//12. DELETE