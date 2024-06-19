<template>
	<view class="findMain">
		<view class="logoImages">

		</view>
		<view class="border">
			<form @submit="onSubmit" class="formInput">
				<input type="text" placeholder="请输入你需要的内容" v-model="searchQuery" class="Finput" />
				<button type="submit" class="searchImages"></button>
			</form>
		</view>
	</view>
</template>

<script>
	export default {
		data() {
			return {
				searchQuery: ''
			}
		},
		methods: {
			onSubmit(event) {
				// 阻止表单的默认提交行为
				event.preventDefault();

				// 构建请求URL
				const baseUrl = 'https://example.com/search'; // 替换为你的基础URL
				const queryParams = `?query=${encodeURIComponent(this.searchQuery)}`;
				const requestUrl = `${baseUrl}${queryParams}`;

				// 发送GET请求
				uni.request({
					url: requestUrl,
					method: 'GET',
					success: (res) => {
						console.log('请求成功:', res);
						// 在这里处理请求成功的逻辑
					},
					fail: (err) => {
						console.error('请求失败:', err);
						// 在这里处理请求失败的逻辑
					}
				});
			}
		}
	}
</script>

<style>
	.findMain {
		width: 100dvw;
		height: 100dvh;
		display: flex;
		flex-direction: column;
		justify-content: center;
		align-items: center;
	}

	.findMain .logoImages {
		width: 300rpx;
		height: 300rpx;
		background: url('/static/findPagesImages/findLogo.png');
		background-repeat: no-repeat;
		background-size: cover;
	}

	.findMain .border {
		width: 80%;
		height: 50%;
	}

	.findMain .border .Finput {
		width: 90%;
		height: 10%;
		border: 4rpx #ccc solid;
		border-radius: 20rpx;
		padding: 20rpx;
	}
</style>