<template>
  <div className="container mx-auto font-mono h-auto text-center">
    <h1 className="text-5xl text-pink-500/70 font-bold mt-32">칵테일 추가</h1>
    <form
      className="bg-white shadow-md px-8 pt-6 pb-8 mb-5 mt-5 rounded-xl"
      v-on:submit.prevent="submitForm"
    >
      <h3 className="text-3xl text-gray-500/70 block font-bold mb-5">
        당신이 사랑하는 칵테일을 추가해 주세요
      </h3>
      <div id="file_input">
        <!-- <input type="file" accept="image/*" /><br> -->
      </div>
      <span className="text-base text-black-500/100 block font-bold mb-5">
        이름 :
        <input
          class="shadow appearance-none border rounded w-auto py-2 px-3 text-gray-700 leading-tight focus:outline-none focus:shadow-outline"
          id="cName"
          type="text"
          placeholder="칵테일 이름"
          v-model="cName"
        /><br />
      </span>

      <span className="text-base text-black-500/100 block font-bold mb-5">
        설명 :
        <input
          class="shadow appearance-none border rounded w-auto py-2 px-3 text-gray-700 leading-tight focus:outline-none focus:shadow-outline"
          id="cDesc"
          type="text"
          placeholder="술에 대해 설명해주세요 :)"
          v-model="cDesc"
        /><br />
      </span>

      <span className="text-base text-black-500/100 block font-bold mb-5">
        도수 :
        <input
          class="shadow appearance-none border rounded w-auto py-2 px-3 text-gray-700 leading-tight focus:outline-none focus:shadow-outline"
          id="cAl"
          type="text"
          placeholder="도수는 몇 도?"
          v-model="cAl"
        /><br />
      </span>

      <span className="text-base text-black-500/100 block font-bold mb-5">
        타입 :
        <select
          id="cType"
          v-model="cType"
          class="shadow appearance-none border rounded w-auto py-2 px-3 text-gray-700 leading-tight focus:outline-none focus:shadow-outline"
        >
          <option
            v-bind:class="cocktailType"
            v-for="(item, index) in listData"
            :key="index"
            :value="item.id"
          >
            {{ item.name }}
          </option>
        </select>
        <br />
      </span>

      <button
        className="font-mono bg-pink-500 hover:bg-pink-700 text-white font-bold py-2 px-4 rounded-full"
        type="submit"
      >
        저장
      </button>
    </form>
  </div>
</template>

<script setup>
import axios from 'axios'
import { computed, ref, watchEffect } from 'vue'

const listData = ref([])
const cName = ref('')
const cDesc = ref('')
const cAl = ref('')
// const cImg = ref("123");
const cType = ref('')

const formData = computed(() => {
  return {
    name: cName.value,
    description: cDesc.value,
    alchol: cAl.value,
    // imgLink : cImg.value,
    cocktailTypeId: cType.value
  }
})

watchEffect(() => {
  axios.get('/cocktail/add').then((res) => {
    let tempArr = [...res.data]
    tempArr.forEach((item) => {
      console.log(item)
      listData.value.push(item)
    })
    console.log(listData)
  })
})

// const submitForm = () => {
//   // console.log(formData.value);
//   axios.post("/cocktail/add", {
//     name : cName.value,
//     description : cDesc.value,
//     alchol : cAl.value,
//     imgLink : cImg.value,
//     cocktailType : cType.value}).then((res) => {
//     console.log(res.data);
//     alert("와!!!!!!!!!!!!!!!!!!!!!");
//   })
// };

const submitForm = () => {
  axios.post('/cocktail/add', formData.value).then((res) => {
    console.log(res.data)
    alert('와!!!!!!!!!!!!!!!!!!!!!')
  })
}
</script>

<style></style>
