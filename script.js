var counter = 1;
var emp_id;
var type_of_vechile;
var employee = [];
var pass;
var employee_name;
var input = document.getElementById("myInput");
input.addEventListener("keyup", function(event) {
    if (input.value.length == 0 && event.key === 'Enter') {
        window.alert("please enter a valid name");
    } else {
        employee_name = input.value;
        onEnter(event, input);
    }

});



function onEnter(event, tohide) {
    if (event.key === 'Enter') {

        event.preventDefault();
        tohide.style.display = 'none';
        counter++;


        //employee.push(tohide.value);


        var message = document.getElementById("input-label");
        if (counter == 2) {
            message.innerHTML = "Hi! " + employee_name + " can  i know your email";
            var email = document.createElement('INPUT');
            email.setAttribute('placeholder', 'abc@gmail.com');
            email.setAttribute('id', 'email');
            document.body.appendChild(email);
            email.addEventListener('keyup', function(event) {

                onEnter(event, email);
            });


        }
        if (counter == 3) {
            message.innerHTML =employee_name + " can  i know your password";
            var password = document.createElement('INPUT');
            password.setAttribute('placeholder', 'password')
            password.setAttribute('id', 'password');
            password.setAttribute('type', 'password');
            document.body.appendChild(password);

            password.addEventListener('keyup', function(event) {
                pass = password.value;


                if (pass.length < 5) {
                    password.style.borderColor = "red";

                }
                if (pass.length >= 5) {
                    password.style.borderColor = "green";
                    if (event.key === 'Enter') {

                        onEnter(event, password);

                    }

                }
            });


        }
        if (counter == 4) {
            message.innerHTML =employee_name + " can you please re type password";
            var confirm = document.createElement('INPUT');
            confirm.setAttribute('placeholder', 're-type password')
            confirm.setAttribute('id', 'confirm');
            confirm.setAttribute('type', 'password');
            document.body.appendChild(confirm);
            confirm.addEventListener('keyup', function(event) {
                if (event.key === 'Enter') {
                    console.log(pass);
                    console.log(confirm.value);
                    if (confirm.value == pass) {
                        onEnter(event, confirm);
                    } else {
                        window.alert('pass and confirm pass are not equal');
                    }

                }

            });


        }
        if (counter == 5) {
            message.innerHTML =employee_name + " can you please enter mobile number";
            var contact = document.createElement('INPUT');
            contact.setAttribute('placeholder', 'mobile number')
            contact.setAttribute('id', 'confirm');
            contact.setAttribute('type', 'password');
            document.body.appendChild(contact);
            contact.addEventListener('keyup', function(event) {

                onEnter(event, contact);
            });


        }
        if (counter == 6) {

            message.innerHTML =employee_name + " can  i know your gender";

            var radiomale = document.createElement('INPUT');

            radiomale.setAttribute('type', 'radio');

            radiomale.setAttribute('name', 'gender');
            radiomale.setAttribute('value', 'male');
            var radiofemale = document.createElement('INPUT');
            radiofemale.setAttribute('value', 'female');
            radiofemale.setAttribute('type', 'radio');
            radiofemale.setAttribute('name', 'gender');
            var malelabel = document.createElement('Label');
            var femalelabel = document.createElement('Label');
            malelabel.innerHTML = "male";
            femalelabel.innerHTML = "female";

            document.body.appendChild(malelabel);
            document.body.appendChild(radiomale);
            document.body.appendChild(femalelabel)
            document.body.appendChild(radiofemale);


            var submit = document.createElement('BUTTON');
            submit.innerHTML = "submit";
            document.body.appendChild(submit);


            submit.addEventListener('click', function(event) {
                femalelabel.style.display = 'none';
                malelabel.style.display = 'none';
                radiofemale.style.display = 'none';
                radiomale.style.display = 'none';
                submit.style.display = 'none';
                onMouseClick(message);
            });

        }
        if (counter == 10) {
            message.innerHTML =employee_name + " can you please select type of vechile";
            var type = document.createElement('SELECT');
            type.setAttribute('id', 'type');
            document.body.appendChild(type);
            var option = document.createElement('OPTION');
            option.setAttribute('value', '2 wheeler');
            var two_wheeler = document.createTextNode("2 wheeler");
            option.appendChild(two_wheeler);
            document.getElementById('type').appendChild(option);
            var option1 = document.createElement('OPTION');
            option1.setAttribute('value', '4 wheeler');
            var four_wheeler = document.createTextNode("4 wheeler");
            option1.appendChild(four_wheeler);
            document.getElementById('type').appendChild(option1);

            var submit = document.createElement('BUTTON');
            submit.innerHTML = "submit";
            document.body.appendChild(submit);

            submit.addEventListener('click', function(event) {
                type.style.display = 'none';
                submit.style.display = 'none';
                toGetPassForm(message, type);

            });





        }
        if (counter == 7) {
            message.innerHTML =employee_name + " can you please enter vechile number";
            var vnum = document.createElement('INPUT');
            vnum.setAttribute('placeholder', 'eg- UP 20 BF 8355')
            vnum.setAttribute('id', 'vnum');
            vnum.setAttribute('type', 'text');
            document.body.appendChild(vnum);
            vnum.addEventListener('keyup', function(event) {

                onEnter(event, vnum);
            });

        }
        if (counter == 8) {
            message.innerHTML =employee_name + " can you please enter employee id";
            var eid = document.createElement('INPUT');
            eid.setAttribute('placeholder', 'eg- E21/1543')
            eid.setAttribute('id', 'eid');
            eid.setAttribute('type', 'text');
            document.body.appendChild(eid);
            eid.addEventListener('keyup', function(event) {

                onEnter(event, eid);
            });

        }
        if (counter == 9) {
            message.innerHTML =employee_name + " can you please enter identification of your vechile";
            var identification = document.createElement('INPUT');
            identification.setAttribute('placeholder', 'eg-black color')
            identification.setAttribute('id', 'identification');
            identification.setAttribute('type', 'text area');
            document.body.appendChild(identification);
            identification.addEventListener('keyup', function(event) {

                onEnter(event, identification);
            });

        }


    }
}

function onMouseClick(message) {
    message.innerHTML =employee_name + " We are proceeding for vechile registration.Can you just enter Vechile name";
    reg_id = Math.random();

    var vname = document.createElement('INPUT');
    vname.setAttribute('placeholder', 'e.g swift dzire')
    vname.setAttribute('id', 'vname');
    vname.setAttribute('type', 'text');

    var reg_id_message = document.createElement('label');
    message.style.display = 'none';
    reg_id_message.innerHTML = "<h1>your registration id is " + Math.floor(reg_id * 10000) + "</h1> ";

    document.body.appendChild(reg_id_message);
    document.body.appendChild(message);
    message.style.display = 'block';
    document.body.appendChild(vname);

    vname.addEventListener('keyup', function(event) {

        onEnter(event, vname);
    });

}

function toGetPassForm(message, type) {
    message.innerHTML =employee_name + " We are proceeding for getting a pass for you.Select a pass";

    type_of_vechile = type.value;
    console.log(type_of_vechile);
    if (type_of_vechile == '2 wheeler') {
        var rate = [10, 200, 1000];

    }
    if (type_of_vechile == '4 wheeler') {
        var rate = [20, 500, 3500];

    }
    var daily_pass = document.createElement('INPUT');
    daily_pass.setAttribute('type', 'radio');
    daily_pass.setAttribute('name', 'pass');
    daily_pass.setAttribute('value', rate[0]);

    var monthly_pass = document.createElement('INPUT');
    monthly_pass.setAttribute('type', 'radio');
    monthly_pass.setAttribute('name', 'pass');
    monthly_pass.setAttribute('value', rate[1]);

    var yearly_pass = document.createElement('INPUT');
    yearly_pass.setAttribute('type', 'radio');
    yearly_pass.setAttribute('name', 'pass');
    yearly_pass.setAttribute('value', rate[2]);

    var daily = document.createElement('Label');
    var monthly = document.createElement('Label');
    var yearly = document.createElement('Label');

    daily.innerHTML = "daily " + rate[0] + " INR";
    monthly.innerHTML = "monthly " + rate[1] + " INR";
    yearly.innerHTML = "yearly " + rate[2] + " INR";

    var submit = document.createElement('BUTTON');
    submit.innerHTML = "submit";

    document.body.appendChild(daily);
    document.body.appendChild(daily_pass);
    document.body.appendChild(monthly);
    document.body.appendChild(monthly_pass);
    document.body.appendChild(yearly);
    document.body.appendChild(yearly_pass);
    document.body.appendChild(submit);
    submit.addEventListener('click', function(event) {
        var ele = document.getElementsByName('pass');

        for (i = 0; i < ele.length; i++) {
            ele[i].style.display = 'none';
            if (ele[i].checked)
                message.innerHTML = 'please pay ' + ele[i].value + '';
        }
        submit.style.display = 'none';
        monthly.style.display = 'none';
        yearly.style.display = 'none';
        daily.style.display = 'none';



    });

}