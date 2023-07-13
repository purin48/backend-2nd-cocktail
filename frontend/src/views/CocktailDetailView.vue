<template>
  <div class="detailContainer">
    <div class="detailBox">
      <section class="detailImg">
        <img src="../assets/logo.svg" alt="#" />
      </section>
      <section class="detailDesc">
        <ul>
          <li>
            <span>이름:</span>
            <p>{{ detailData[0].name}}</p>
          </li>
          <li>
            <span>설명:</span>
            <p>{{ detailData[0].description }}</p>
          </li>
          <li>
            <span>도수:</span>
            <p>{{ detailData[0].alchol }}</p>
          </li>
          <li>
            <span>타입:</span>
            <p>{{ detailData[0].cocktailType.name }}</p>
          </li>
        </ul>
      </section>
    </div>
    <div class="btnBox">
      <button type="button" @click="updateBtn">수정</button>
      <button type="button" @click="deleteBtn">삭제</button>
    </div>
  </div>
</template>

<script setup>
import axios from 'axios'
import { ref, watchEffect } from 'vue'
import router from '../router';

const detailData = ref([]);

const currentPath = window.location.pathname;
console.log(currentPath);

watchEffect(() => {
  axios.get(`/cocktail${currentPath}`).then((response) => {
    detailData.value.push(response.data);
  });
});

const updateBtn = () => {
  router.push({path:`${currentPath}/edit`});
  // router.replace({path:`${currentPath}/edit`});
  // window.location = `${currentPath}/edit`;
}

const deleteBtn = () => {
  axios.delete(`/cocktail${currentPath}/delete`).then((response) => {
    console.log(response);
    alert("칵테일이 지워졌습니다!");
    router.push({path:`/list`});
  });  
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

<style scoped>
.detailContainer {
  width: 100%;
  height: 100%;
  display: flex;
  flex-direction: column;
  justify-content: center;
}

.detailBox {
  display: flex;
  justify-content: center;
  align-items: center;
  gap: 3%;
}

.btnBox {
  display: flex;
  justify-content: center;
  align-items: center;
  gap: 3%;
}

.detailImg {
  width: 300px;
  height: 300px;
}

.detailDesc p {
  margin-left: 10px;
  display: inline-block;
}

li{
   list-style-type: none;
}

li span{
  font-weight: bold;
}
</style>