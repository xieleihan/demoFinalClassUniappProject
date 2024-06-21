<template>
	<view class="main">
		<view class="content">
			<view class="top">
				<view class="topAvatar"></view>
				<view class="userNameInfo">Hello World!</view>
			</view>
			<view class="setting">
				<view class="btn changePassword">修改密码</view>
				<view class="btn exitLogin">退出登录</view>
			</view>
			<view class="about">Copyright&copy;2024 SouthAki,All rights reserved.</view>
		</view>
	</view>
</template>

<script>
	export default {
		data() {
			return {

			}
		},
		methods: {

		}
	}
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