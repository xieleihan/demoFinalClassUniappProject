<template>
	<view class="main">
		<view class="content">
			<view class="projectTitle">
				云上书库
			</view>
			<view class="projectInfo">
				<view class="projectInfo1">Copyright&copy; 2024 SouthAki,All rights reserved.</view>
				<view class="projectInfo2">
					　　你好,我是本项目云上书库的开发者SouthAki,现在我来说明下我的项目的一些基本情况,我的项目前端使用的是uniApp+css+typescript,后端使用的是Springboot,持久化是MySQL,现在这个项目的话是开源协议GPL3.0,任何人都可以在不需要经过我许可的情况下,用于学习用途,或者你想基于这个想法去进行二次开发也行.基于该项目的衍生开发作品我不声张任何版权.
				</view>
				<view>
					　　然后,我希望你能够一起参与到这个开源项目中来,完善这个项目,因为我本人不能又做前端又做后端的,导致前后端我都觉得差点意思.
				</view>
				<view>
					　　没事,我依旧感谢你的帮助,谢谢.
				</view>
				<view class="footer">开源项目<a href="https://github.com/xieleihan/demoFinalClassUniappProject">[点击访问]</a>
				</view>
			</view>
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
		height: calc(100dvh - 90rpx);
		background: url('/static/bg.png');
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

	.main .content .projectTitle {
		font-size: 100rpx;
		margin-top: 40rpx;
		/* font-weight: bold; */
	}

	.main .content .projectInfo {
		word-break: break-all;
		padding: 10px;
	}

	.main .content .projectInfo .projectInfo1 {
		font-size: 25rpx;
		text-align: center;
	}

	.main .content .projectInfo .projectInfo2 {
		padding-top: 10rpx;
	}

	.main .content .projectInfo .footer {
		text-align: center;
		padding-top: 30rpx;
	}
</style>