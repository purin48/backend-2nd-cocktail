import { fileURLToPath, URL } from 'node:url'

import { defineConfig } from 'vite'
import vue from '@vitejs/plugin-vue'

// https://vitejs.dev/config/

export default defineConfig({
  plugins: [
    vue(),
  ],
  resolve: {
    alias: {
      '@': fileURLToPath(new URL('./src', import.meta.url))
    }
  },
  
  build: {
    outDir: "../backend/cocktail/src/main/resources/static",
  }, // 빌드 결과물이 생성되는 경로
  server: {
    // proxy: {
    //   "/cocktail": "http://localhost:8080",
    //   changeOrigin : true
    // }, // proxy 설정
  },
})
