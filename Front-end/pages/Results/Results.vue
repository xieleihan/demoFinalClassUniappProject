<template>
	<view class="resultsMain">
		<view v-for="book in books" :key="book.id" class="bookItem">
			<image :src="book.bookpic" class="bookImage" mode="aspectFit" />
			<view class="bookDetails">
				<text class="bookTitle">{{ book.booktitle }}</text>
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
					url: `http://localhost:9807/bookinfo/search?query=${this.query}`,

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
		padding: 20px;
	}

	.bookItem {
		margin-bottom: 20px;
	}

	.bookImage {
		width: 100px;
		height: 100px;
		object-fit: cover;
	}

	.bookDetails {
		margin-left: 10px;
	}

	.bookTitle {
		font-weight: bold;
	}

	.bookInfo {
		color: gray;
	}
</style>