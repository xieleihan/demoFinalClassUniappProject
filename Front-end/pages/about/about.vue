<template>
	<view class="main">
		<view class="content">
			<view class="top">
				<view class="topAvatar" :style="{ backgroundImage: 'url(' + userPic + ')' }"></view>
				<view class="userNameInfo">{{ username }}</view>
			</view>
			<view class="setting">
				<view class="btn changePassword" @click="goToChangePassword">&gt; 修改密码</view>
				<view class="btn uploadFile" @click="goToUpLoadFilePage">&gt; 上传文件</view>
				<view class="btn adminBook" @click="goToAdminPages">&gt; 管理书库</view>
				<view class="btn exitLogin" @click="goToLogninPages">&gt; 退出登录</view>
			</view>
			<view class="about" @click="goToAboutProjectPages">Copyright&copy;2024 SouthAki,All rights reserved.</view>
		</view>
	</view>
</template>

<script>
	export default {
		data() {
			return {
				username: '', // 用于存储用户名
				userPic: '' // 用于存储 Base64 编码的图片
			};
		},
		mounted() {
			this.username = localStorage.getItem('username'); // 获取保存的用户名
			this.fetchUserPic();
		},
		methods: {
			goToAdminPages() {
				uni.navigateTo({
					url: '/pages/adminPages/adminPages'
				})
			},
			goToLogninPages() {
				uni.navigateTo({
						url: '/pages/Longin/Longin'
					}),
					uni.clearStorage()
			},
			goToChangePassword() {
				uni.navigateTo({
					url: '/pages/changePassword/changePassword'
				})
			},
			goToUpLoadFilePage() {
				// 使用 uni.navigateTo 方法跳转到注册页面
				uni.navigateTo({
					url: '/pages/upLoadFile/upLoadFile' // 注册页面的路径，根据实际情况修改
				});
			},
			goToAboutProjectPages() {
				uni.navigateTo({
					url: '/pages/aboutProjectPages/aboutProjectPages'
				})
			},
			fetchUserPic() {
				uni.request({
					url: `http://localhost:2282/user/getUserPic?username=${this.username}`, // 将参数直接拼接在 URL 中，使用模板字符串
					method: 'GET',
					success: (res) => {
						if (res.data && res.data.length > 0) {
							this.userPic = 'data:image/png;base64,' + res.data; // 设置 Base64 图片
						} else {
							console.error('Empty or invalid Base64 data received.');
						}
					},
					fail: (err) => {
						console.error('Error fetching user pic:', err);
					}
				});
			},
			base64ToArrayBuffer(base64) {
				const binaryString = window.atob(base64);
				const len = binaryString.length;
				const bytes = new Uint8Array(len);
				for (let i = 0; i < len; i++) {
					bytes[i] = binaryString.charCodeAt(i);
				}
				return bytes.buffer;
			},
			logout() {
				localStorage.removeItem('username');
				// 其他的登出逻辑，比如跳转到登录页面
			}
		}
	};
</script>


<style scoped>
	.main {
		width: 100dvw;
		height: calc(100dvh - 190rpx);
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

	.main .content .top {
		width: 90%;
		height: 20%;
		/* background-color: skyblue; */
		position: relative;
		margin-top: 40rpx;
	}

	.main .content .top .topAvatar {
		width: 100rpx;
		height: 100rpx;
		border-radius: 50%;
		background-color: red;
		background-position: center;
		background-size: cover;
		position: absolute;
		top: 50%;
		left: 15%;
		transform: translate(-50%, -50%);
	}

	.main .content .top .userNameInfo {
		position: absolute;
		top: 50%;
		left: 50%;
		transform: translate(-50%, -50%);
		font-size: 50rpx;
	}

	.main .content .setting {
		width: 90%;
		margin-top: 100rpx;
		/* background-color: lightblue; */
	}

	.main .content .setting .btn {
		background-color: #ccc;
		width: 100%;
		height: 60rpx;
		display: flex;
		justify-content: center;
		align-items: center;
		margin-bottom: 50rpx;
	}

	.main .content .setting .changePassword:hover {
		background-color: skyblue;
		width: 100%;
		height: 60rpx;
		display: flex;
		justify-content: center;
		align-items: center;
		margin-bottom: 50rpx;
	}

	.main .content .setting .exitLogin:hover {
		background-color: lightcoral;
		width: 100%;
		height: 60rpx;
		display: flex;
		justify-content: center;
		align-items: center;
		margin-bottom: 50rpx;
	}

	.main .content .setting .uploadFile:hover {
		background-color: lightgreen;
		width: 100%;
		height: 60rpx;
		display: flex;
		justify-content: center;
		align-items: center;
		margin-bottom: 50rpx;
	}

	.main .content .setting .adminBook:hover {
		background-color: lightseagreen;
		width: 100%;
		height: 60rpx;
		display: flex;
		justify-content: center;
		align-items: center;
		margin-bottom: 50rpx;
	}

	.main .content .about {
		position: absolute;
		bottom: 1%;
		left: 50%;
		transform: translate(-50%, -50%);
		font-size: 20rpx;
		width: 90%;
		text-align: center;
	}
</style>