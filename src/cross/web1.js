var flag = require("./flag.js");
var express = require('express');
var app = express();

app.get('/flag', function(req,res) {
	if(req.query.first) {
		if(req.query.first.length == 8 && req.query.first == ",,,,,,,") {
			res.send(flag.flag);
			return;
		}
	}
	res.send("Try to solve this.");
});
app.listen(31337)

function check1(str) {
	return str.length == 8 && str == ",,,,,,,";
}
// str is [undefined, undefined, undefined, undefined, undefined, undefined, undefined, undefined].

var flag = require("./flag.js");
var express = require('express')
var app = express()
app.get('/flag', function(req,res){ 
	if (req.query.second) { 
		if (req.query.second != "1" && req.query.second.length == 10 && req.query.second == true) {
			res.send(flag.flag);
			return;
		}
	}
	res.send("Try to solve this.");
});
app.listen(31337)

function check2(str) {
	return str.length != "1" && str.length == 10 && str == true;
}
// str is "0000000001"

var flag = require("./flag.js");
var express=require('express');
var app=express();

app.get('/flag', function(req, res){
	if(req.query.third) {
		if(Array.isArray(req.query.third)) {
			third = req.query.third;
			third_sorted = req.query.third.sort();
			if(Number.parseInt(third[0]) > Number.parseInt(third[1]) && third_sorted[0] == third[0] && third_sorted[1] == third[1]) {
				res.send(flag.flag);
				return;
			}
		}
	}
	res.send("Try to solve this.");
});
app.listen(31337);

function check3(str1, str2) {
	return Number.parseInt(str1) > Number.parseInt(str2) && str1 < str2;
}
