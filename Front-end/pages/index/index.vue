<template>
	<view class="main">
		<view class="uni-margin-wrap">
			<swiper class="swiper" circular :indicator-dots="indicatorDots" :autoplay="autoplay" :interval="interval"
				:duration="duration">
				<swiper-item v-for="(image, index) in images" :key="index">
					<view class="swiper-item">
						<image :src="image" class="swiper-image"></image>
					</view>
				</swiper-item>
			</swiper>
		</view>
		<view class="bigTitle">云上书库</view>
		<view class="item">
			<view class="images"></view>
			<view class="bookInfo">
				<view class="title">你好</view>
				<view class="info">
					你好你好你好你好你好你好你好你好你好你好你好你好你好你好你好你好你好你好你好你好你好你好你好你...
				</view>
			</view>
		</view>
	</view>
</template>


<script>
	export default {
		data() {
			return {
				indicatorDots: true,
				autoplay: true,
				interval: 2000,
				duration: 500,
				images: [] // 初始化为空数组
			}
		},
		mounted() {
			this.generateRandomImages();
		},
		methods: {
			generateRandomImages() {
				const baseUrl = 'https://picsum.photos/1920/1080'; // 替换为你的基础URL
				for (let i = 0; i < 6; i++) {
					const randomNum = Math.floor(Math.random() * 100); // 生成随机数
					this.images.push(`${baseUrl}?${randomNum}`);
				}
			}
		}
	}
</script>

<style scoped>
	.main {
		width: 100dvw;
		height: 100dvh;
		display: flex;
		flex-direction: column;
		align-items: center;
	}

	.main .bigTitle {
		font-weight: bold;
		font-size: 50rpx;
		margin-top: 40rpx;
	}

	.main .item {
		width: 90%;
		height: 15%;
		border: 1rpx black solid;
		border-radius: 20rpx;
		display: flex;
		flex-direction: row;
		justify-content: space-evenly;
		align-items: center;
		margin-top: 50rpx;
	}

	.main .item .images {
		width: 30%;
		height: 90%;
		background-color: skyblue;
		margin-left: 20rpx;
	}

	.main .item .bookInfo {
		width: 50%;
		height: 90%;
	}

	.main .item .bookInfo .title {
		font-weight: bold;
		font-size: 40rpx;
		font-family: "PingFang SC";
		margin-bottom: 40rpx;
	}

	.main .item .bookInfo .info {
		height: 50%;
		overflow: hidden;
		-webkit-line-clamp: 3;
		text-overflow: ellipsis;
		display: -webkit-box;
		-webkit-box-orient: vertical;
	}

	.main .uni-margin-wrap {
		width: 690rpx;
		width: 100%;
	}

	.main .uni-margin-wrap .swiper {
		height: 300rpx;
	}

	.main .uni-margin-wrap .swiper .swiper-item {
		display: block;
		height: 300rpx;
		line-height: 300rpx;
		text-align: center;
	}

	.main .uni-margin-wrap .swiper .swiper-item .swiper-image {
		width: 100%;
		height: 100%;
	}
</style>