webpackJsonp([19],{"4/WD":function(e,t,s){"use strict";Object.defineProperty(t,"__esModule",{value:!0});var r=s("LPk9"),a=s("FJop"),n={data:function(){return{fellPathSetInterval:null,imageUrl:"",keyStorePath:"",keyStoreInfo:{}}},components:{Back:r.a,Password:a.a},mounted:function(){},methods:{keystore:function(){var e=this,t=document.getElementById("fileId");t.click();this.fellPathSetInterval=setInterval(function(){if(""!==e.getFullPath(t)){var s=document.getElementById("fileId"),r=document.querySelector("#preview");if(window.FileReader)if("keystore"===s.files[0].name.toLowerCase().split(".").splice(-1)[0]){if(window.FileReader){var a=s.files[0],n=new FileReader;n.onload=function(){r.innerHTML=this.result},n.readAsText(a),setTimeout(function(){var t=JSON.parse(r.innerHTML);if(e.keyStoreInfo={address:"null"===t.address?null:t.address,encryptedPrivateKey:"null"===t.encryptedPrivateKey?null:t.encryptedPrivateKey,alias:"null"===t.alias?null:t.alias,pubKey:"null"===t.pubKey?null:t.pubKey,prikey:"null"===t.prikey?null:t.prikey},"null"!==JSON.parse(r.innerHTML).encryptedPrivateKey)e.$refs.password.showPassword(!0);else{var s={accountKeyStoreDto:e.keyStoreInfo,password:"",overwrite:!1};e.postKeyStore("/account/import",s)}},500)}}else s.outerHTML=s.outerHTML,e.$message({type:"warning",message:e.$t("message.c194"),duration:"800"});clearInterval(e.fellPathSetInterval)}},500)},upload:function(e){if(window.FileReader){var t=e.files[0],s=(t.name.split(".")[0],new FileReader);s.onload=function(){return this.result},s.readAsText(t)}return!0},getFullPath:function(e){if(e)return window.navigator.userAgent.indexOf("MSIE")>=1?(e.select(),document.selection.createRange().text):window.navigator.userAgent.indexOf("Firefox")>=1&&e.files?e.files.item(0).getAsDataURL():e.value},toSubmit:function(e){var t={accountKeyStoreDto:this.keyStoreInfo,password:e,overwrite:!1};this.postKeyStore("/account/import",t);var s=document.getElementById("fileId");s.outerHTML=s.outerHTML},postKeyStore:function(e,t){var s=this;this.$post(e,t).then(function(e){e.success?(document.querySelector("#preview").innerHTML="",s.getAccountList("/account"),s.$message({type:"success",message:s.$t("message.passWordSuccess")})):s.$message({type:"warning",message:s.$t("message.passWordFailed")+e.msg})})},getAccountList:function(e){var t=this;this.$fetch(e).then(function(e){e.success&&(t.$store.commit("setAddressList",e.data.list),1===e.data.list.length?(localStorage.setItem("newAccountAddress",e.data.list[0].address),localStorage.setItem("encrypted",e.data.list[0].encrypted),t.$router.push({name:"/wallet"})):t.$router.push({name:"/userInfo",params:{address:e.data}}),t.$message({type:"success",message:t.$t("message.passWordSuccess")}))}).catch(function(e){console.log("User List err"+e)})},importKey:function(){this.$router.push({path:"/firstInto/firstInfo/importKey"})}}},i={render:function(){var e=this,t=e.$createElement,s=e._self._c||t;return s("div",{staticClass:"import-account"},[s("Back",{attrs:{backTitle:this.$t("message.firstInfoTitle")}}),e._v(" "),s("h1",[e._v(e._s(e.$t("message.inportAccount")))]),e._v(" "),s("input",{staticClass:"hidden",attrs:{type:"file",id:"fileId"}}),e._v(" "),s("p",{staticClass:"hidden",attrs:{id:"preview",value:""}}),e._v(" "),s("div",{staticClass:"keystore",on:{click:e.keystore}},[s("h1",[e._v(e._s(e.$t("message.c189")))]),e._v(" "),s("p",[e._v(e._s(e.$t("message.c190"))),s("br"),e._v(e._s(e.$t("message.c191")))]),e._v(" "),s("h3",{directives:[{name:"show",rawName:"v-show",value:!1,expression:"false"}]},[e._v("\n      "+e._s(e.$t("message.c192"))+"\n    ")])]),e._v(" "),s("div",{staticClass:"key text-d cursor-p",on:{click:e.importKey}},[e._v(e._s(e.$t("message.c193")))]),e._v(" "),s("Password",{ref:"password",on:{toSubmit:e.toSubmit}})],1)},staticRenderFns:[]};var o=s("vSla")(n,i,!1,function(e){s("Kdr/")},null,null);t.default=o.exports},"Kdr/":function(e,t){}});