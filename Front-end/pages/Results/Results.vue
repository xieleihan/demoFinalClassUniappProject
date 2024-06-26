<template>
	<view class="resultsMain">
		<view v-for="book in books" :key="book.id" class="bookItem">
			<image :src="book.bookpic" class="bookImage" mode="aspectFit" />
			<view class="bookDetails">
				<text class="bookTitle">{{ book.booktitle }}</text>
				<br />
				<text class="bookInfo">{{ book.bookinfo }}</text>
			</view>
		</view>
	</view>
</template>

<script>
	export default {
		data() {
			return {
				books: [],
				query: ''
			};
		},
		onLoad(options) {
			this.query = options.query || '';
			this.fetchResults();
		},
		methods: {
			fetchResults() {
				uni.request({
					url: `http://localhost:2282/bookinfo/search?query=${this.query}`,

					method: 'GET',
					success: (res) => {
						if (res.data && res.data.length) {
							this.books = res.data.map(book => ({
								...book,
								bookpic: `data:image/png;base64,${book.bookpic}`
							}));
						}
					},
					fail: (err) => {
						console.error('Error fetching book results:', err);
					}
				});
			}
		}
	};
</script>

<style scoped>
	.resultsMain {
		padding: 30rpx;
		width: 100dvw;
		height: calc(100dvh - 90rpx);
	}

	.bookItem {
		width: 50%;
		height: 40%;
		border: 1px #ccc solid;
		position: relative;
	}

	.bookImage {
		width: 300rpx;
		height: 300rpx;
		object-fit: cover;
		position: absolute;
		top: 40%;
		left: 50%;
		transform: translate(-50%, -50%);
		border: 1px #ccc solid;
		padding: 20rpx;
		border-radius: 20rpx;
	}

	.bookDetails {
		position: absolute;
		top: 80%;
		left: 40%;
		transform: translate(-50%, -50%);
		margin-top: 20rpx;
	}

	.bookTitle {
		font-weight: bold;
	}

	.bookInfo {
		color: gray;
	}
</style>