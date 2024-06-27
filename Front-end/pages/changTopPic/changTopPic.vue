<template>
	<view class="main">
		<view class="content">
			<button @click="chooseImage" class="btnImages">选择图片</button>
			<view class="imagesPrint">
				<image :src="previewImage" class="imagesBorderR" mode="aspectFit" v-if="previewImage" />
			</view>
			<button type="primary" @click="upload" class="subBtn">上传</button>
		</view>
	</view>
</template>

<script>
	export default {
		data() {
			return {
				previewImage: '', // 用于显示选中的图片
				base64Image: '', // 用于存储 Base64 编码的图片
				username: '' // 假设从localstorage或者其他地方获取的用户名
			}
		},
		methods: {
			chooseImage() {
				const input = document.createElement('input');
				input.type = 'file';
				input.accept = 'image/*';
				input.onchange = (e) => {
					const file = e.target.files[0];
					if (file) {
						this.previewImage = URL.createObjectURL(file);
						this.convertToBase64(file);
					}
				};
				input.click();
			},
			convertToBase64(file) {
				const reader = new FileReader();
				reader.onload = (e) => {
					this.base64Image = e.target.result.split(',')[1]; // 获取 Base64 编码内容
				};
				reader.readAsDataURL(file);
			},
			upload() {
				const requestData = {
					username: this.username,
					pic: this.base64Image
				};
				uni.request({
					url: 'http://localhost:2282/usertoppic', // 后端上传图片的接口
					method: 'POST',
					data: {
						username: localStorage.getItem('username'),
						pic: this.base64Image
					},

					header: {
						'Content-Type': 'application/json' // 设置请求头
					},
					success: (res) => {
						console.log('图片上传成功:', res);
						console.log('Upload data:', requestData);
						uni.showToast({
							title: '上传成功',
							icon: 'success',
							duration: 2000
						});
					},
					fail: (err) => {
						console.error('图片上传失败:', err);
						uni.showToast({
							title: '上传失败，请重试',
							icon: 'none',
							duration: 2000
						});
					}
				});
			}
		}
	}
</script>

<style scoped>
	.main {
		width: 100dvw;
		height: calc(100dvh - 95rpx);
		background: url('https://picsum.photos/1080/1920');
		background-repeat: no-repeat;
		background-size: cover;
		background-attachment: fixed;
		display: flex;
		justify-content: center;
		align-items: center;
	}

	.main .content {
		width: 90%;
		height: 70%;
		background-color: rgba(255, 255, 255, .9);
		border-radius: 20rpx;
		display: flex;
		align-items: center;
		flex-direction: column;
		position: relative;
		/* justify-content: space-evenly; */
	}
</style>