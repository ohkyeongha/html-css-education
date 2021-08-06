window.onload = function(){

   const signInBtn = document.getElementById("signIn");
   const signUpBtn = document.getElementById("signUp");
   const fistForm = document.getElementById("form1");
   const secondForm = document.getElementById("form2");
   const container = document.querySelector(".container");
   const loginBtn = document.getElementById("signin-btn");
   
   loginBtn.onclick = function(){
		document.signinForm.submit()
   }
   
   signInBtn.addEventListener("click", () => {
      container.classList.remove("right-panel-active");
   });
   
   signUpBtn.addEventListener("click", () => {
      container.classList.add("right-panel-active");
   });
   
   fistForm.addEventListener("submit", (e) => e.preventDefault());
   secondForm.addEventListener("submit", (e) => e.preventDefault());
}