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
    database:'messages'
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

//list user whit id
app.get('/list_users_id/:id',(req,res)=>{
    connectionDB.query('SELECT * FROM users WHERE id=?',[req.params.id],(err, rows, fields)=>{
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
    connectionDB.query('INSERT INTO users (firstname, lastname, email, phone, password) VALUES (?,?,?,?,?)', [req.body.firstname, req.body.lastname, req.body.email,req.body.phone, req.body.password],(err, rows, fields)=>{
        if(!err){
            console.log("User has been inserted");
            res.send("user has been register");
        }           
        else
            console.log(err);
    })
});

//10. GET/look for an user
app.post('/update_users',(req,res)=>{
    connectionDB.query('UPDATE users SET firstname=?, lastname=?, email=?, phone=?, password=? where id=?', [req.body.firstname, req.body.lastname, req.body.email,req.body.phone, req.body.password, req.body.id],(err, rows, fields)=>{
        if(!err){
            console.log("User has been updated");
            res.send("user has been updated");
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


//13. GET all messages
app.get('/list_message',(req,res)=>{
    connectionDB.query('SELECT * FROM message',(err, rows, fields)=>{
        if(!err){
            console.log(rows);
            res.send(rows);
        }           
        else
            console.log(err);
    })
});

//lista de mensajes filtrados por chat
app.get('/list_chat_messages/:id',(req,res)=>{
    connectionDB.query('SELECT m.value, m.id_user_send, id_chat FROM message as m inner join chat as c where c.id=?',[req.params.id],(err, rows, fields)=>{
        if(!err){
            console.log(rows);
            res.send(rows);
        }           
        else
            console.log(err);
    })
});

//insert messages 
app.post('/insert_message',(req,res)=>{
    connectionDB.query('INSERT INTO message (id_chat, id_user_send, value) VALUES (?,?,?)', [req.body.id_chat, req.body.id_user_send, req.body.value],(err, rows, fields)=>{
        if(!err){
            console.log("Message has been inserted");
            console.log(rows.insertId); //obtengo el id del mensaje que se creo
            res.send(""+rows.insertId); //envio el id que se acabo de crear
            //res.send("Message has been register");
        }           
        else
            console.log(err);
    })
});

//insert new chat 
app.post('/insert_chat',(req,res)=>{
    var datos = {};
    connectionDB.query('INSERT INTO chat (date) VALUES (?)', [req.body.date],(err, rows, fields)=>{
        if(!err){
            console.log("Chat has been inserted");
            console.log(rows.insertId); //obtengo el id del mensaje que se creo
            res.send(""+rows.insertId); //envio el id que se acabo de crear
            datos = {'id_chat':rows.insertId}
            console.log(datos)
            //res.send("Message has been register");
        }           
        else
            console.log(err);
    })
});

// login 
app.post('/login',(req,res)=>{
  
    connectionDB.query('SELECT * FROM users WHERE email=? AND password=?', [req.body.email,req.body.password],(err, rows, fields)=>{
        if(!err){
            console.log("¡¡¡ login !!");
            console.log(rows); //obtengo el id del mensaje que se creo
            //res.send(""+rows.insertId); //envio el id que se acabo de crear
           // datos = {'id_chat':rows.insertId}
           res.send(rows)
           
        }           
        else
            console.log(err);
    })
});
