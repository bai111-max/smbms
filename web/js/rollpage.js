function page_nav(frm,num){
		frm.pageIndex.value = num;
		frm.submit();
}

function jump_to(frm,num){
    //alert(num);

	var regexp=/^[1-9]\d*$/;
	var totalPageCount = document.getElementById("totalPageCount").value;
	//alert(totalPageCount);
	if(!regexp.test(num)){
		alert("请输入大于0的正整数");
		return false;
	}else if((num-totalPageCount) > 0){
		alert("请输入小于于总页数的数");
		return false;
	}else{
		page_nav(frm,num);
	}
}