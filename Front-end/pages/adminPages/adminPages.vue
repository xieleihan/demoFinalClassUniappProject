<template>
	<view class="main">
		<view class="content">
			<view class="title">进入管理员页面</view>
			<input placeholder="请输入管理员账号" type="text" v-model="adminName" class="ipt" />
			<input placeholder="请输入管理员密码" type="password" v-model="adminPsw" class="ipt" />
			<view class="adminLognin" @click="submitLognin">登录</view>
		</view>
	</view>
</template>

<script>
	export default {
		data() {
			return {
				adminName: '',
				adminPsw: ''
			}
		},
		methods: {
			submitLognin() {
				console.log('用户输入：', this.adminName, this.adminPsw);
				uni.request({
					url: 'http://localhost:2282/adminuser/login',
					method: 'POST',
					data: {
						username: this.adminName,
						password: this.adminPsw
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
									// localStorage.setItem('username', this.username); // 保存用户名
									uni.navigateTo({
										url: '/pages/bookInfo/bookInfo'
									})
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
		height: calc(100dvh - 95rpx);
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
		background-color: rgba(255, 255, 255, .9);
		border-radius: 20rpx;
		display: flex;
		align-items: center;
		flex-direction: column;
		position: relative;
		/* justify-content: space-evenly; */
	}

	.main .content .title {
		font-size: 60rpx;
		margin-top: 40rpx;
		margin-bottom: 30rpx;
	}

	.main .content .ipt {
		width: 70%;
		height: 30rpx;
		text-align: center;
		border: 1px #ccc solid;
		padding: 20rpx;
		margin-bottom: 30rpx;
		border-radius: 20rpx;
	}

	.main .content .adminLognin {
		width: 70%;
		height: 30rpx;
		background-color: skyblue;
		padding: 30rpx;
		display: flex;
		justify-content: center;
		align-items: center;
		border-radius: 20rpx;
	}
</style>