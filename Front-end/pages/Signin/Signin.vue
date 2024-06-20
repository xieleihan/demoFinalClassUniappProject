<template>
	<view class="main">
		<view class="content">
			<view class="title">云上书库</view>
			<view class="info">注册页</view>
			<input v-model="user.username" type="text" placeholder="请输入用户名" class="priInput userInput" />
			<input v-model="user.tel" type="tel" placeholder="请输入手机号" class="priInput telInput" />
			<input v-model="user.password" type="password" placeholder="请输入密码" class="priInput pswInput" />
			<button type="primary" @click="registerUser" class="subBtn">注册</button>
		</view>
	</view>
</template>

<script>
	export default {
		data() {
			return {
				user: {
					username: '',
					tel: '',
					password: ''
				}
			};
		},
		methods: {
			registerUser() {
				console.log('用户输入：', this.user);
				uni.request({
					url: 'http://localhost:9807/register',
					method: 'POST',
					data: this.user,
					header: {
						'content-type': 'application/json' // 根据后端要求设置合适的 Content-Type
					},
					success: (res) => {
						console.log('Response from server:', res.data);
						uni.navigateTo({
							url: '/pages/Longin/Longin'
						});
						// 处理注册成功的情况，比如跳转页面等操作
						uni.showToast({
							title: '注册成功',
							icon: 'success',
							duration: 2000
						});
					},
					fail: (err) => {

						console.error('Error during registration:', err);
						// 处理注册失败的情况，比如显示错误消息等操作
						uni.showToast({
							title: '注册失败，请重试',
							icon: 'none',
							duration: 2000
						});
					}
				});
			}
		}
	};
</script>

<style scoped>
	@font-face {
		font-family: 'zk';
		/* 字体名称 */
		src: url('/static/font/zk.ttf;') format('truetype');
	}

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
		height: 80%;
		background-color: rgba(255, 255, 255, .9);
		border-radius: 20rpx;
		display: flex;
		align-items: center;
		flex-direction: column;
		justify-content: space-evenly;
	}

	.main .content .title {
		font-family: zk;
		font-weight: bold;
		font-size: 70rpx;
	}

	.main .content .priInput {
		border-radius: 20rpx;
		border: 4rpx #ccc solid;
		padding: 20rpx;
		width: 60%;
	}

	.main .content .subBtn {
		width: 70%;
		background-color: #e64340;
	}
</style>