//const form_connora = document.querySelector('.form_connectionORA');
/*
const form_queue = document.querySelector('.form_queues');
const form_sendsmg = document.querySelector('.form_send_msg');
*/
//const submit_connora_f = form_connora.querySelector('[type="submit"]');
/*
const submit_queue_f = form_queue.querySelector('[type="submit"]');
const submit_send_f = form_sendsmg.querySelector('[type="submit"]');
*/
//const list_group_action = document.querySelectorAll('.list-group-item');
//const connection_ora = list_group_action[0];
//const send_msg = list_group_action[1];

/*
function connection_ora_f(e){
    active_item(e.target.innerHTML);
}

function active_item(item_name){
    for(let e of list_group_action){
        e.classList.remove('active');
    }

    for(let e of list_group_action){
        if(e.innerHTML === item_name){
            e.classList.add('active');
            return;
        } 
       
    }

}
*/

/*
connection_ora.onclick  = connection_ora_f;

send_msg.onclick = ()=>{
    alert("send")
}

function form_connora_hide(){
   form_connora.classList.add('hide');
   form_queue.classList.remove('hide');
}

function form_queue_hide(){
    form_queue.classList.add('hide');
    form_sendsmg.classList.remove('hide');
    active_item("Send message");
}

submit_connora_f.onclick = form_connora_hide;
submit_queue_f.onclick = form_queue_hide;
*/
const input_q = document.querySelector('.q_name');

function disconnect_db(){
    fetch('/disconnect',{method:'GET'});
}

function current_q(e){
input_q.setAttribute('value',e);
 //fetch('/current_queue?' + new URLSearchParams({q:e}),{method:'GET'})
}