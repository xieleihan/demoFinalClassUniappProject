<template>
	<view class="findMain">
		<view class="logoImages"></view>
		<view class="border">
			<form @submit.prevent="onSubmit" class="formInput">
				<input type="text" placeholder="请输入你需要的内容" v-model="searchQuery" class="Finput" />
				<button type="submit" class="searchInput">
					<span class="iconfont icon-sousuo butFont"></span>
				</button>
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

<style scoped>
	@import url('/static/iconfont/iconfont.css');
	/* 引入iconfont.css文件 */

	.findMain {
		width: 100vw;
		height: calc(100dvh - 190rpx);
		position: relative;
	}

	.findMain .logoImages {
		width: 300rpx;
		height: 300rpx;
		background: url('/static/findPagesImages/findLogo.png');
		background-repeat: no-repeat;
		background-size: cover;
		position: absolute;
		top: 30%;
		left: 50%;
		transform: translate(-50%, -50%);
	}

	.findMain .border {
		width: 80%;
		position: absolute;
		top: 52%;
		left: 50%;
		transform: translate(-50%, -50%);
	}

	.findMain .border .formInput {
		display: inline-block;
		width: 100%;
		/* 确保表单宽度为容器宽度 */
	}

	.findMain .border .Finput {
		display: inline-block;
		width: calc(100% - 50px);
		height: 40px;
		border: 4rpx #ccc solid;
		border-radius: 20rpx;
		padding: 10px;
		box-sizing: border-box;
		/* 确保padding包含在内 */
	}

	.findMain .border .searchInput {
		display: inline-block;
		font-family: "iconfont" !important;
		/* 确保使用 iconfont 字体 */
		width: 40px;
		height: 40px;
		border: none;
		background: transparent;
		padding: 0;
		/* margin-left: 10px; */
	}

	.findMain .border .formInput .searchInput .butFont {
		display: block;
		width: 100%;
		height: 100%;
	}
</style>