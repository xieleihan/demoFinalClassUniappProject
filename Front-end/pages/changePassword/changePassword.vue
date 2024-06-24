<template>
	<view class="main">
		<view class="content">
			<input v-model="tel" placeholder="请输入手机号" type="tel" class="ipt inputTel" />
			<input v-model="password" placeholder="请输入密码" type="password" class="ipt inputPsw" />
			<input v-model="truePassword" placeholder="请再次输入密码" type="password" class="ipt inputTruePsw" />
			<view class="btn" @click="submitIns">提交修改</view>
			<view class="warnningInfo">Warnning:请注意,修改密码后,是立即生效,请牢记你的密码.</view>
		</view>
	</view>
</template>

<script>
	export default {
		data() {
			return {
				tel: '',
				password: '',
				truePassword: ''
			}
		},
		methods: {
			submitIns() {
				if (this.password !== this.truePassword) {
					uni.showModal({
						title: '错误',
						content: '密码不一致，请重新输入',
						showCancel: false
					});
					return;
				}
				uni.request({
					url: 'http://localhost:9807/updata/updatePassword', // 这里填写你的后端URL
					method: 'POST',
					data: {
						tel: this.tel,
						password: this.password
					},
					success: (res) => {
						if (res.statusCode === 200) {
							uni.showToast({
								title: '密码修改成功',
								icon: 'success'
							});
						} else {
							uni.showModal({
								title: '错误',
								content: res.data.message || '密码修改失败',
								showCancel: false
							});
						}
					},
					fail: (err) => {
						uni.showModal({
							title: '错误',
							content: '请求失败，请稍后重试',
							showCancel: false
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

	.main .content .ipt {
		width: 70%;
		height: 70rpx;
		border: 1px #ccc solid;
		border-radius: 20rpx;
		margin-bottom: 30rpx;
		padding: 10rpx;
		text-align: center;
	}

	.main .content .ipt:nth-child(1) {
		margin-top: 30rpx;
	}

	.main .content .btn {
		width: 70%;
		height: 70rpx;
		background-color: skyblue;
		padding: 10rpx;
		display: flex;
		justify-content: center;
		align-items: center;
		border-radius: 20rpx;
	}

	.main .content .warnningInfo {
		width: 90%;
		position: absolute;
		bottom: 10rpx;
		left: 50%;
		transform: translate(-50%, -50%);
		font-size: 25rpx;
		text-align: center;
	}

	.main .content .warnningInfo:hover {
		color: lightcoral;
	}
</style>