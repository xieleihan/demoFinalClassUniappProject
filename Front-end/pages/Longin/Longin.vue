<template>
	<view class="main">
		<view class="content">
			<view class="title">云上书库</view>
			<view class="info">登录页</view>
			<input v-model="username" type="text" placeholder="请输入账号" class="accInput" />
			<input v-model="password" type="password" placeholder="请输入密码" class="pswInput" />
			<view class="subBtn">
				<button type="primary" @click="loginUser">登录</button>
				<button type="warn" @click="goToRegisterPage">注册</button>
			</view>
		</view>
	</view>
</template>

<script>
	export default {
		data() {
			return {
				username: '',
				password: ''
			};
		},
		methods: {
			// 点击按钮时触发跳转逻辑
			goToRegisterPage() {
				// 使用 uni.navigateTo 方法跳转到注册页面
				uni.navigateTo({
					url: '/pages/Signin/Signin' // 注册页面的路径，根据实际情况修改
				});
			},
			loginUser() {
				console.log('用户输入：', this.username, this.password);
				uni.request({
					url: 'http://localhost:9807/login',
					method: 'POST',
					data: {
						username: this.username,
						password: this.password
					},
					header: {
						'content-type': 'application/json' // 根据后端要求设置合适的 Content-Type
					},
					success: (res) => {
						console.log('Response from server:', res.data);

						if (res.data.success) {
							// 登录成功处理，例如跳转到主页
							uni.showToast({
								title: '登录成功',
								icon: 'success',
								duration: 2000,
								success: () => {
									uni.switchTab({
										url: '/pages/index/index'
									});
								}
							});
						} else {
							// 登录失败处理，例如显示错误消息
							uni.showToast({
								title: '用户名或密码错误',
								icon: 'none',
								duration: 2000
							});
						}
					},
					fail: (err) => {
						console.error('Error during login:', err);
						uni.showToast({
							title: '登录失败，请重试',
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
		height: 100dvh;
		display: flex;
		justify-content: center;
		align-items: center;
		background: url('../../static/bg.png');
		background-repeat: no-repeat;
		background-size: cover;
	}

	.main .content {
		width: 90%;
		height: 70%;
		display: flex;
		flex-direction: column;
		align-items: center;
		justify-content: space-evenly;
		background-color: rgba(255, 255, 255, 0.9);
		border-radius: 20rpx;
	}

	.main .content .title {
		font-weight: bold;
		font-size: 70rpx;
	}

	.main .content .accInput {
		border: 4rpx #ccc solid;
		width: 70%;
		padding: 20rpx;
		border-radius: 20rpx;
	}

	.main .content .pswInput {
		width: 70%;
		border: 4rpx #ccc solid;
		padding: 20rpx;
		border-radius: 20rpx;
	}

	.main .content .subBtn {
		width: 70%;
		display: flex;
	}
</style>