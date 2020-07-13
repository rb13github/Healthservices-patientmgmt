insert into employee(employeeId, employeeName , employeeAddress,employeeEmail) values('1','Jack','USA','jack@gmail.com');
insert into employee(employeeId, employeeName , employeeAddress,employeeEmail) values('2','RB','India','kumar@gmail.com');
insert into employee(employeeId, employeeName , employeeAddress,employeeEmail) values('3','RB1','India','kumar1@gmail.com');


insert into product(name,brand,madein,price) values('sanitizer','lifeboy','india',50.55);

insert into product(name,brand,madein,price) values('mask','wild','india',100.00);

insert into appuser(username,password,email,role) values('rbadmin','rb123','rb@yahoo.com','admin');

insert into appuser(username,password,email,role) values('rbtest','rb123','rb@yahoo.com','dev');

INSERT INTO public.patient(
	quarantine_duration, name, mobile, age, address, "covidPatient")
	VALUES (14, 'john', '2929292929', '30', 'abcbdd', true);
	
	
	===============================================================


INSERT INTO public."roleMaster"(
	"roleId", "roleDesc", status)
	VALUES (101, 'admin', true);

INSERT INTO public."UserMaster"(
	"userId", "userName", fname, mname, lname, status, password, "roleId")
	VALUES (10,'rbtest1','ritesh','k','bh',true,'rb123',101);
	
	
	INSERT INTO public."UserMaster"(
	"userId", "userName", fname, mname, lname, status, password, "roleId")
	VALUES (11,'rbadmin','ritesh','k','bh',true,'rb123',101);


INSERT INTO public."ProductMaster"(
	"ItemId", "ItemCode", "ItemDesc", "ItemType", "BalanceQty", "UpdateBy", "ItemUnit", status)
	VALUES (1111, 'code101', 'lifeboy','sanitizer',100,11,'50', true);
                   
                   
                   INSERT INTO public."ProductMaster"(
	"ItemId", "ItemCode", "ItemDesc", "ItemType", "BalanceQty", "UpdateBy", "ItemUnit", status)
	VALUES (2222, 'code202', 'wildcraft','mask',200,11,'60', true);
	
	
	 INSERT INTO public."ProductMaster"(
	"ItemId", "ItemCode", "ItemDesc", "ItemType", "BalanceQty", "UpdateBy", "ItemUnit", "UpdateDate", status)
	VALUES (3333, 'code303', 'sensoplus','sensor',200,11,'600','2020-07-07', true);
	
	
	 
	UPDATE public."ProductMaster"
	SET "ItemId"=?, "ItemCode"=?, "ItemDesc"=?, "ItemType"=?, "BalanceQty"=?, "UpdateDate"=?, "UpdateBy"=?, "ItemUnit"=?, status=?
	WHERE <condition>;
	
	UPDATE public."ProductMaster"
	SET "UpdateDate"= '2020-07-07' where "ItemId"=?
	
	INSERT INTO public."ProductAllocation"(
	"ItemtransId", "ItemCode", "IssueQty", "BuildingNo", "IssueDate", "IssueBy", "ItemId")
	VALUES (101, 'code303', 100, 1, ,11, 3333);
	
		INSERT INTO public."ProductAllocation"(
	"ItemtransId", "ItemCode", "IssueQty", "BuildingNo", "IssueDate", "IssueBy", "ItemId")
	VALUES (102, 'code303', 200, 2, '2020-07-08',11, 3333);
	
		INSERT INTO public."ProductAllocation"(
	"ItemtransId", "ItemCode", "IssueQty", "BuildingNo", "IssueDate", "IssueBy", "ItemId")
	VALUES (103, 'code202', 500, 1, '2020-07-08',11, 2222);
	
	INSERT INTO public."ProductAllocation"(
	"ItemtransId", "ItemCode", "IssueQty", "BuildingNo", "IssueDate", "IssueBy", "ItemId")
	VALUES (104, 'code202', 555, 2, '2020-07-08',11, 2222);
	
	
	
	select  "BuildingNo","ItemCode",SUM ("IssueQty") from public."ProductAllocation"   group by "BuildingNo","ItemCode";
