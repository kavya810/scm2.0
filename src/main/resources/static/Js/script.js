console.log("Script loaded")

//change theme work

let currentTheme=getTheme();

document.addEventListener("DOMContentLoaded", () =>{
     changeTheme();
});

function changeTheme(){
// set to web page
    
    changePageTheme(currentTheme , currentTheme);

    //set the listener to change the theme button 
    const changeThemeButton = document.querySelector('#theme_change_button');
    
    const oldTheme = currentTheme

    changeThemeButton.addEventListener("click",(event) =>{
      
        console.log("change theme button");
        document.querySelector('html').classList.remove(currentTheme);
        if(currentTheme=="dark"){
           currentTheme = "light"
        }else{

            currentTheme = "dark"
        }

        changePageTheme(currentTheme, oldTheme);
    });

}
//set theme to  local storage
function setTheme(theme){
  
    
    localStorage.setItem("theme", theme);

}
function getTheme(){
    let theme = localStorage.getItem("theme");
    if(theme) return theme;
    else return "Light";
}



function changePageTheme(theme , oldTheme){

    //local storage me update karenge 
    setTheme(currentTheme);
    document.querySelector('html').classList.remove(oldTheme);

    //set the current theme
    document.querySelector('html').classList.add(theme);

    //change the text of button
    document.querySelector('#theme_change_button').querySelector("span").textContent = theme == "light" ? "dark" : "light";

}

//end of change theme work