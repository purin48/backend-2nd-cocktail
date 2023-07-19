import './style.css'

import { createApp } from 'vue'
import { createPinia } from 'pinia'

import App from './App.vue'
import router from './router'
import axios from 'axios'

axios.defaults.baseURL = 'http://13.209.19.24:8080'

const app = createApp(App)
app.config.globalProperties.axios = axios

app.use(createPinia())
app.use(router)

app.mount('#app')
