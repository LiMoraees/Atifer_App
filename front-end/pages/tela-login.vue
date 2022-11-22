<template>
    <div class="container">
      <form @submit.prevent="doLogin">
        <h2 class="mb-3">Login</h2>
        <div class="input">
          <label for="email">Nome</label>
          <input
            class="form-control"
            type="text"
            name="text"
            placeholder="Insira seu nome"
            v-model="formLogin.username"
          />
        </div>
        <div class="input">
          <label for="password">Senha</label>
          <input
            class="form-control"
            type="password"
            name="password"
            placeholder="senha123"
            v-model="formLogin.password"
          />
        </div>
        <!-- <div class="alternative-option mt-4">
          You don't have an account? <span @click="moveToRegister">Register</span>
        </div> -->
        <button type="submit" class="mt-4 btn-pers" id="login_button">
          Login
        </button>
        <div
          class="alert alert-warning alert-dismissible fade show mt-5 d-none"
          role="alert"
          id="alert_1"
        >
          Lorem ipsum dolor sit amet consectetur, adipisicing elit.
          <button
            type="button"
            class="btn-close"
            data-bs-dismiss="alert"
            aria-label="Close"
          ></button>
        </div>
      </form>
    </div>
  </template>
  
  <script>

  export default {
    // Define que essa página está acessível para todo mundo
    auth: false,
    layout: 'no_layout',
    data() {
      return {
        formLogin:{
          username: "teste",
          password: "1234",
        }        
      };
    },

    methods:{
      async setAuthToken(data){
        const authHeader = 'Bearer ' + data.token;
        // console.log(data.token);
        // console.log(data);
        this.$auth.setUserToken(authHeader, null);
        this.$axios.setHeader('Authorization', authHeader);
        // this.$auth.ctx.app.$axios.setHeader('Authorization', authHeader);
        // const response = await this.$axios.get('/user/me', {
        //     headers:{
        //       'Authorization': authHeader,
        //     }
        //   }
        // )
        const response = await this.$axios.get('/user/me');
        this.$auth.setUser(response.data); 
        // this.$router.push('/');
      },

      async doLogin(){
        try{
          const response = await this.$axios.post("/login", this.formLogin);

          if(response.data.data.token){
            await this.setAuthToken(response.data.data);
          }

          if (this.$auth.loggedIn) {
            console.log('Successfully Logged In')
            console.log(this.$auth.strategy.token)
            console.log(this.$auth.strategy)
            this.$router.push('/')
          }
        }catch(error){
          console.log(error);
          alert("Nome ou senha incorretos!");
        }
      }
    }
  };
  </script>