<template>
	<view class="main">
		<view class="content">
			<button @click="chooseImage" class="btnImages">选择图片</button>
			<view class="imagesPrint">
				<image :src="previewImage" class="imagesBorderR" mode="aspectFit" v-if="previewImage" />
			</view>
			<input v-model="bookTitle" type="text" class="upInput bookTitle" placeholder="请输入书籍的标题" />
			<input v-model="bookInfo" type="text" class="upInput bookInfo" placeholder="请输入书籍的相关信息" />
			<button type="primary" @click="upLoad">上传</button>
		</view>
	</view>
</template>

<script>
	export default {
		data() {
			return {
				previewImage: '', // 用于显示选中的图片
				base64Image: '', // 用于存储 Base64 编码的图片
				bookTitle: '', // 用于存储图书标题
				bookInfo: '' // 用于存储图书信息
			};
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
			upLoad() {
				uni.request({
					url: 'http://localhost:9807/bookinfo/upload', // 后端上传图片的接口
					method: 'POST',
					data: {
						bookpic: this.base64Image,
						booktitle: this.bookTitle,
						bookinfo: this.bookInfo
					},
					header: {
						'Content-Type': 'application/json' // 设置请求头
					},
					success: (res) => {
						console.log('Book info uploaded successfully:', res);
						// 处理成功后的逻辑
					},
					fail: (err) => {
						console.error('Error uploading book info:', err);
					}
				});
			}
		}
	};
</script>

<style scoped>
	.main {
		width: 100dvw;
		height: calc(100dvh - 90rpx);
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
		height: 80%;
		background-color: rgba(255, 255, 255, .9);
		border-radius: 20rpx;
		display: flex;
		flex-direction: column;
		align-items: center;
	}

	.main .content .btnImages {
		width: 70%;
		margin-top: 100rpx;
	}

	.main .content .imagesPrint {
		width: 300rpx;
		height: 300rpx;
		display: flex;
		justify-content: center;
		align-items: center;
		border-radius: 20rpx;
		border: 1px #ccc solid;
		padding: 10rpx;
		margin: 30rpx 0 30rpx;
	}

	.main .content .imagesPrint .imagesBorderR {
		border-radius: 20rpx;
	}

	.main .content .upInput {
		width: 70%;
		border: 1px solid black;
		padding: 20rpx;
		border-radius: 20rpx;
		margin-bottom: 30rpx;
	}
</style>