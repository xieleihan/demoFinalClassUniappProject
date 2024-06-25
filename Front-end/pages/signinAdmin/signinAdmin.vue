<template>
	<view>
		<input v-model="adminName" type="text" />
		<input v-model="adminPsw" type="password" />
		<button type="primary" @click="signinAdmin">注册</button>
	</view>
</template>

<script>
	export default {
		data() {
			return {
				adminName: '',
				adminPsw: ''
			}
		},
		methods: {
			signinAdmin() {
				uni.request({
					url: 'http://localhost:2282/adminuser/register',
					method: 'POST',
					data: {
						username: this.adminName,
						password: this.adminPsw
					},
					header: {
						'content-type': 'application/json' // 根据后端要求设置合适的 Content-Type
					},
					success: (res) => {
						console.log('注册成功:', res.data);
						uni.showToast({
							title: '注册成功',
							icon: 'success',
							duration: 2000,
							success: () => {
								console.log("注册成功")
							}
						});
					},
					fail: (err) => {
						console.error('注册失败:', err);
						uni.showToast({
							title: '注册失败，请重试',
							icon: 'none',
							duration: 2000
						});
					}
				})
			}
		}
	}
</script>

<style>

</style>