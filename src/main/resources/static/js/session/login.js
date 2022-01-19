const loginForm = document.querySelector('.login-form');
const loginId = loginForm.querySelector('#id');
const loginPassword = loginForm.querySelector('#pw');
const loginButton = loginForm.querySelector('button');

const sessionLogin = async () => {

    const body = {email: loginId.value, password: loginPassword.value};

    const { data } = await axios.post('/session/login', body);

    if(data.isSuccess) {
        alert('로그인 성공');
        location.href = '/session/';
        return;
    }

    alert('로그인 실패');
};

loginButton.addEventListener('click', () => sessionLogin());
