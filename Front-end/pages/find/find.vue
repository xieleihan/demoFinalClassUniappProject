<template>
	<view class="findMain">
		<view class="logoImages"></view>
		<view class="border">
			<input type="text" placeholder="请输入你需要的内容" v-model="searchQuery" class="Finput" />
			<button @click="submitVal" type="default" class="searchInput iconfont icon-sousuo"></button>
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
			submitVal() {
				if (this.searchQuery.trim() !== '') {
					// 通过 URL 传递搜索查询参数
					uni.navigateTo({
						url: `/pages/Results/Results?query=${this.searchQuery}`
					});
				}
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