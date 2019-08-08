//criacao de constrollers
appCliente.controller("loginController", function ($scope, $http){
	
	$scope.usuario={};
	
	$scope.token = "";
	
	$scope.autenticar = function (){
		//console.log("CHAMOU AUTENTICAR: "); 
		$http.post("/autenticar",$scope.usuario).then(function(response){ //http://localhost:8080/autenticar
			console.log("Sucesso - "+response);
			$scope.token = response.data.token;
			localStorage.setItem("userToken", response.data.token);
			
		},function(response){
			console.log("Falha - "+response);
			
		});	
		
		//console.log("NOME: "+$scope.usuario.nome + " SENHA:"+$scope.usuario.senha);
		
	}

	
});