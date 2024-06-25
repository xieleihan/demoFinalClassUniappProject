<template>
	<view class="main">
		<view class="content">
			<scroll-view :scroll-top="scrollTop" scroll-y="true" class="scroll-Y" @scrolltoupper="upper"
				@scrolltolower="lower" @scroll="scroll">
				<view v-for="book in books" :key="book.id" class="bookItem">
					<image :src="book.bookpic" class="bookImage" mode="aspectFit" />
					<view class="bookDetails">
						<text class="bookTitle">{{ book.booktitle }}</text>
						<text class="bookInfo">{{ book.bookinfo }}</text>
					</view>
					<button type="warn" @click="deleteBook">删除</button>
				</view>
			</scroll-view>
		</view>
	</view>
</template>

<script>
	export default {
		data() {
			return {
				books: [],
				scrollTop: 0
			}
		},
		onLoad() {
			this.fetchBooks();
		},
		methods: {
			fetchBooks() {
				uni.request({
					url: 'http://localhost:9807/bookinfo/books',
					method: 'GET',
					success: (response) => {
						if (response.statusCode === 200) {
							this.books = response.data.map(book => {
								const imageUrl = `data:image/png;base64,${book.bookpic}`;
								return {
									...book,
									bookpic: imageUrl
								};
							});
						} else {
							console.error('Error fetching books:', response);
						}
					},
					fail: (error) => {
						console.error('Error fetching books:', error);
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
</style>