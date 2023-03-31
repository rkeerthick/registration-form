
function submit(e) {
    e.preventDefault();
    const form = document.getElementById("form-details");
    const formData = new FormData(form);
    const data = {};
    for (let [key, value] of formData.entries()) {
      data[key] = value;
    }
    console.log(data);
    if(checkInputs(data))
    {
        form.submit();
    }
  }
  function checkInputs(data) {
    let firstName = data.first-name;
    let lastName = data.last-name;
    let email = data.email;
    let password = data.password;
    let errors = [];
    if (firstName.trim() === "") {
      errors.push("First name is required");
    }
  
  	if (lastName.trim() === "") {
      errors.push("Last name is required");
    }
  
    if (email.trim() === "") {
      errors.push("Email is required");
    } else if (!isValidEmail(email)) {
      errors.push("Email is not valid");
    }
  
    if (errors.length > 0) {
      console.log(errors);
      return false;
    }

    return true;
  }
  
  function isValidEmail(email) {
    const regex = /^[\w-\.]+@([\w-]+\.)+[\w-]{2,4}$/;
    return regex.test(email);
  }