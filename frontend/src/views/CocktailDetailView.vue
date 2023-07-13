<template>
  <div className="container mx-auto font-mono h-auto text-center">
    <div>
      <section class="detailImg">
        <img src="../assets/logo.svg" alt="#" />
      </section>
      <section class="detailDesc">
        <ul>
          <li className="bg-white p-2 m-2 w-auto rounded-lg shadow-lg">
            <span className="text-base text-black-500/100 block font-bold mb-5">이름:</span>
            <p>{{ detailData[0].name }}</p>
          </li>
          <li className="bg-white p-2 m-2 w-auto rounded-lg shadow-lg">
            <span className="text-base text-black-500/100 block font-bold mb-5">설명:</span>
            <p>{{ detailData[0].description }}</p>
          </li>
          <li className="bg-white p-2 m-2 w-auto rounded-lg shadow-lg">
            <span className="text-base text-black-500/100 block font-bold mb-5">도수:</span>
            <p>{{ detailData[0].alchol }}</p>
          </li>
          <li className="bg-white p-2 m-2 w-auto rounded-lg shadow-lg">
            <span className="text-base text-black-500/100 block font-bold mb-5">타입:</span>
            <p>{{ detailData[0].cocktailType.name }}</p>
          </li>
        </ul>
      </section>
    </div>
    <div class="btnBox">
      <button
        className="font-mono bg-sky-500 hover:bg-sky-700 text-white font-bold py-2 px-4 rounded-full"
        type="button"
        @click="updateBtn"
      >
        수정
      </button>
      <button
        className="font-mono bg-red-500 hover:bg-red-700 text-white font-bold py-2 px-4 rounded-full"
        type="button"
        @click="deleteBtn"
      >
        삭제
      </button>
    </div>
  </div>
</template>

<script setup>
import axios from 'axios'
import { ref, watchEffect } from 'vue'
import router from '../router'

const detailData = ref([])

const currentPath = window.location.pathname
console.log(currentPath)

watchEffect(() => {
  axios.get(`/cocktail${currentPath}`).then((response) => {
    detailData.value.push(response.data)
  })
})

const updateBtn = () => {
  router.push({ path: `${currentPath}/edit` })
  // router.replace({path:`${currentPath}/edit`});
  // window.location = `${currentPath}/edit`;
}

const deleteBtn = () => {
  axios.delete(`/cocktail${currentPath}/delete`).then((response) => {
    console.log(response)
    alert('칵테일이 지워졌습니다!')
    router.push({ path: `/list` })
  })
}

// defineProps({
//     Item:{
//         name : detailData[0].name,
//         desc :  detailData[0].description,
//         alchol : detailData[0].alchol,
//         cocktailType : detailData[0].cocktailType.name

//     }
// })
</script>

<style scoped></style>
