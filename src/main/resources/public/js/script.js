const query_q_all = document.querySelector('.query_all');
const query_q_curr = document.querySelector('.query_curr');
const query_q_cust = document.querySelector('.query_cust');
const query_q_drop = document.querySelectorAll('.rounded-pill');

const select_qp = document.querySelector('.select_qp');
const JMSDestination = document.querySelector('#q_name');

var q_name = 'none';

function disconnect_db(){
    fetch('/disconnect',{method:'GET'});
}

function current_q(e){
    select_qp.innerHTML = '<b>Select queue: </b>' + e;
    q_name = e;
    JMSDestination.setAttribute('value',q_name);
 //fetch('/current_queue?' + new URLSearchParams({q:e}),{method:'GET'})
}

function active_q_all(){
    query_q_all.classList.toggle('bg-success');
    query_q_curr.classList.remove('bg-success');
    query_q_cust.classList.remove('bg-success');
}

function active_q_curr(){
    query_q_curr.classList.toggle('bg-success');
    query_q_all.classList.remove('bg-success');
    query_q_cust.classList.remove('bg-success');
}

function active_q_cust(){
    query_q_cust.classList.toggle('bg-success');
    query_q_curr.classList.remove('bg-success');
    query_q_all.classList.remove('bg-success');
}

const props = document.querySelector('.aq_props');

/*JMSMessageID*/
const JMSMessageID = document.createElement("input");
JMSMessageID.setAttribute('type','text');
JMSMessageID.setAttribute('id','JMSMessageID');
JMSMessageID.setAttribute('name','MessageID');
JMSMessageID.classList.add('form-control');
JMSMessageID.classList.add('form-control-sm');

const JMSMessageID_label = document.createElement("label");
JMSMessageID_label.setAttribute('for','JMSMessageID');
JMSMessageID_label.classList.add('form-label');
JMSMessageID_label.classList.add('form-control-sm');
JMSMessageID_label.innerHTML = "JMSMessageID";

function addJmsMessageId(){
    props.append(JMSMessageID_label);
    props.append(JMSMessageID);
}

/*JMSCorrelationID*/
const JMSCorrelationID = document.createElement("input");
JMSCorrelationID.setAttribute('type','text');
JMSCorrelationID.setAttribute('id','JMSCorrelationID');
JMSCorrelationID.setAttribute('name','CorrelationID');
JMSCorrelationID.classList.add('form-control');
JMSCorrelationID.classList.add('form-control-sm');

const JMSCorrelationID_label = document.createElement("label");
JMSCorrelationID_label.setAttribute('for','JMSCorrelationID');
JMSCorrelationID_label.classList.add('form-label');
JMSCorrelationID_label.classList.add('form-control-sm');
JMSCorrelationID_label.innerHTML = "JMSCorrelationID";

function addJMSCorrelationID(){
    props.append(JMSCorrelationID_label);
    props.append(JMSCorrelationID);
}

/*JMSExpiration*/
const JMSExpiration = document.createElement("input");
JMSExpiration.setAttribute('type','text');
JMSExpiration.setAttribute('id','JMSExpiration');
JMSExpiration.setAttribute('name','Expiration');
JMSExpiration.classList.add('form-control');
JMSExpiration.classList.add('form-control-sm');

const JMSExpiration_label = document.createElement("label");
JMSExpiration_label.setAttribute('for','JMSExpiration');
JMSExpiration_label.classList.add('form-label');
JMSExpiration_label.classList.add('form-control-sm');
JMSExpiration_label.innerHTML = "JMSExpiration";

function addJMSExpiration(){
    props.append(JMSExpiration_label);
    props.append(JMSExpiration);
}

/*JMSDestination*/
/*const JMSDestination = document.createElement("input");
JMSDestination.setAttribute('type','text');
JMSDestination.setAttribute('id','JMSDestination');
JMSMessageID.setAttribute('name','Destination');
JMSDestination.classList.add('form-control');
JMSDestination.classList.add('form-control-sm');

const JMSDestination_label = document.createElement("label");
JMSDestination_label.setAttribute('for','JMSDestination');
JMSDestination_label.classList.add('form-label');
JMSDestination_label.classList.add('form-control-sm');
JMSDestination_label.innerHTML = "JMSDestination";

function addJMSDestination(){
    props.append(JMSDestination_label);
    props.append(JMSDestination);
}*/

/*JMSReplyTo*/
const JMSReplyTo = document.createElement("input");
JMSReplyTo.setAttribute('type','text');
JMSReplyTo.setAttribute('id','JMSReplyTo');
JMSReplyTo.setAttribute('name','ReplyTo');
JMSReplyTo.classList.add('form-control');
JMSReplyTo.classList.add('form-control-sm');

const JMSReplyTo_label = document.createElement("label");
JMSReplyTo_label.setAttribute('for','JMSReplyTo');
JMSReplyTo_label.classList.add('form-label');
JMSReplyTo_label.classList.add('form-control-sm');
JMSReplyTo_label.innerHTML = "JMSReplyTo";

function addJMSReplyTo(){
    props.append(JMSReplyTo_label);
    props.append(JMSReplyTo);
}

/*JMSPriority*/
const JMSPriority = document.createElement("input");
JMSPriority.setAttribute('type','text');
JMSPriority.setAttribute('id','JMSPriority');
JMSPriority.setAttribute('name','Priority');
JMSPriority.classList.add('form-control');
JMSPriority.classList.add('form-control-sm');

const JMSPriority_label = document.createElement("label");
JMSPriority_label.setAttribute('for','JMSPriority');
JMSPriority_label.classList.add('form-label');
JMSPriority_label.classList.add('form-control-sm');
JMSPriority_label.innerHTML = "JMSPriority";

function addJMSPriority(){
    props.append(JMSPriority_label);
    props.append(JMSPriority);
}

/*JMSDeliveryMode*/
const JMSDeliveryMode = document.createElement("input");
JMSDeliveryMode.setAttribute('type','text');
JMSDeliveryMode.setAttribute('id','JMSDeliveryMode');
JMSDeliveryMode.setAttribute('name','DeliveryMode');
JMSDeliveryMode.classList.add('form-control');
JMSDeliveryMode.classList.add('form-control-sm');

const JMSDeliveryMode_label = document.createElement("label");
JMSDeliveryMode_label.setAttribute('for','JMSDeliveryMode');
JMSDeliveryMode_label.classList.add('form-label');
JMSDeliveryMode_label.classList.add('form-control-sm');
JMSDeliveryMode_label.innerHTML = "JMSDeliveryMode";

function addJMSDeliveryMode(){
    props.append(JMSDeliveryMode_label);
    props.append(JMSDeliveryMode);
}