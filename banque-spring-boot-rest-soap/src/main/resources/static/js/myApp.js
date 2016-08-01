var app=angular.module("myBanqueApp",[]);
app.controller("myBanqueController", function($scope,$http) {
	$scope.compte= null;
	$scope.codeCompte=null;
	$scope.operation={type:"versement",montant:0,codeCp2:null};
	$scope.pageOperations=[];
	$scope.pageCourante=0;
	$scope.pageSize=3;
	$scope.pages=[];
	
	$scope.chargerCompte=function()
	{
		$scope.pageCourante=0;
		$http.get("/comptes/"+$scope.codeCompte)
		.success(function(data){
			$scope.compte=data;
			$scope.chargerOperations();
		});
	};
	
	$scope.goToPage=function(p)
	{
		$scope.pageCourante=p;
		$scope.chargerOperations();
	};
	
	$scope.chargerOperations=function()
	{
		$http.get("/operations?"+"codeCp="+$scope.codeCompte+"&page="+$scope.pageCourante+"&size="+$scope.pageSize)
		.success(function(data){
			$scope.pageOperations=data;
			$scope.pages=new Array(data.totalPages);
		});
	};
	
	$scope.saveOperation=function()
	{
		var params="";
		if($scope.operation.type=='virement')
		{
			params="codeCp1="+$scope.codeCompte+"&codeCp2="+$scope.operation.codeCp2+"&montant="+$scope.operation.montant+"&codeEmp=1";
		}
		else
		{
			params="codeCp="+$scope.codeCompte+"&montant="+$scope.operation.montant+"&codeEmp=1";
		}
		$http({
				method : 'PUT',
				url    : $scope.operation.type,
				data   : params,
				headers : {'Content-Type': 'application/x-www-form-urlencoded'}
			})
			.success(function(data){
				 $scope.chargerCompte();
			});
			
	};
	
});