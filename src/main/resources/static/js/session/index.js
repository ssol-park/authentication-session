const logoutButton = document.querySelector('.logout');

const logout = async () => {
    const { data } = await axios.post('/session/logout');
    if(data.isSuccess) location.href = '/session/login';
};

logoutButton.addEventListener('click', () => logout());