function getEmployeeDetails() {
	var eid = document.getElementById("eid").value;

	var req = new XMLHttpRequest();
	req.open("GET","http://localhost:8011/WebApp-EMS/EmployeeController?eid=" + eid, true);
	req.onreadystatechange = function() {
		if (req.readyState == 4 && req.status == 200) {
			var res = req.responseText;
			var arr = res.split(" ");
			document.getElementById("ename").value = arr[0];
			document.getElementById("salary").value = arr[1];
			document.getElementById("dno").value = arr[2];
		}
	};
	req.send();
}