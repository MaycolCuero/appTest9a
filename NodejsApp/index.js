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
// this allow register data whit method post 
app.use(bodyparser.urlencoded({
    extended:true
}));

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
app.post('/insert_users',(req,res)=>{
    connectionDB.query('INSERT INTO users (firstname, lastname, email, phone) VALUES (?,?,?,?)', [req.body.firstname, req.body.lastname, req.body.email,req.body.phone],(err, rows, fields)=>{
        if(!err){
            console.log("User has been inserted");
            res.send("user has been register");
        }           
        else
            console.log(err);
    })
});

//11. INSERT/UPDATE
app.delete('/delete_users/:id',(req,res)=>{
    connectionDB.query('DELETE FROM users WHERE id=?', [req.params.id],(err, rows, fields)=>{
        if(!err){
            console.log("User has been deleted");
            res.send("User has been deleted");
        }           
        else
            console.log(err);
    })
});

//12. DELETE
app.delete('/delete_users/:id',(req,res)=>{
    connectionDB.query('DELETE FROM users WHERE id=?', [req.params.id],(err, rows, fields)=>{
        if(!err){
            console.log("User has been deleted");
            res.send("User has been deleted");
        }           
        else
            console.log(err);
    })
});