<template>
  <div>
      <h1>칵테일 추가</h1>
      <form v-on:submit.prevent="submitForm">
          <h3>당신이 사랑하는 칵테일을 추가해 주세요</h3>
          <div id="file_input">
              <!-- <input type="file" accept="image/*" /><br> -->
          </div>
          <span>
              이름 :
              <input id="cName" type="text" placeholder="칵테일 이름" v-model="cName"><br>
          </span>

          <span>
              설명 : <input id="cDesc" type="text" placeholder="술에 대해 설명해주세요 :)" v-model ="cDesc"><br>
          </span>


          <span>
              도수 : <input id="cAl" type="text" placeholder="도수는 몇 도?" v-model ="cAl"><br>
          </span>


          <span>
              타입 : <select id="cType" v-model ="cType">
                <option v-bind:class = "cocktailType" v-for="(item, index) in listData" :key="index" :value="item.id">
                  {{ item.name }}
                </option>
              </select><br>
          </span>

          <button type="submit">저장</button>
      </form>
  </div>
</template>

<script setup>
import axios from "axios";
import router from "../router";
import { computed, ref, watchEffect } from "vue";


const listData = ref([]);
const cName = ref("");
const cDesc = ref("");
const cAl = ref("");
// const cImg = ref("123");
const cType = ref("");

const formData = computed(() => {
  return {
    name : cName.value,
    description : cDesc.value,
    alchol : cAl.value,
    // imgLink : cImg.value,
    cocktailTypeId: cType.value
  }
});


watchEffect(() => {
  axios.get("/cocktail/add").then(res => {
    let tempArr = [...res.data];
    tempArr.forEach((item) => {
      console.log(item);
      listData.value.push(item);
    });
    console.log(listData);
    
  });
});

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
  axios.post("/cocktail/add", formData.value).then((res) => {
    console.log(res.data);
    alert("와!!!!!!!!!!!!!!!!!!!!!");
  })
};
</script>

<style>
input {
  display: inline-block;
  margin: 1rem;
}

h1 {
  margin-bottom: 2rem;
}

#file_input {
  border: dashed 2px;
}
</style>