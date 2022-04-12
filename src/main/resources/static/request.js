const request = axios.create({
    baseURL: "/erupt-api", // url = base url + request url
    // withCredentials: true, // send cookies when cross-domain requests
    timeout: 5000 // request timeout
})

// request interceptor
request.interceptors.request.use(
    config => {
        if (parent.getAppToken().token) {
            config.headers['token'] = parent.getAppToken().token
        }
        return config
    },
    error => {
        // console.log(error) // for debug
        ELEMENT.Message.error(error)
        return Promise.reject(error)
    }
)

// response interceptor
request.interceptors.response.use(
    /**
     * If you want to get http information such as headers or status
     * Please return  response => response
     */

    /**
     * Determine the request status by custom code
     * Here is just an example
     * You can also judge the status by HTTP Status Code
     */
    response => {
        const res = response.data

        // if the custom code is not 20000, it is judged as an error.
        if (res.code !== 1) {
            // Message({
            //     message: res.detail || res.message || 'Error',
            //     type: 'error',
            //     duration: 5 * 1000
            // })
            ELEMENT.Message({
                message: res.msg || res.message || 'Error',
                type: 'error',
                duration: 5 * 1000
            })

            // 50008: Illegal token; 50012: Other clients logged in; 50014: Token expired;
            if (res.code === 50008) {
                // to re-login
                location.reload()

                // MessageBox.confirm('You have been logged out, you can cancel to stay on this page, or log in again', 'Confirm logout', {
                //     confirmButtonText: 'Re-Login',
                //     cancelButtonText: 'Cancel',
                //     type: 'warning'
                // }).then(() => {
                //     store.dispatch('user/resetToken').then(() => {
                //         location.reload()
                //     })
                // })
            }

            return Promise.reject(new Error(res.message || 'Error'))
        } else {
            return res
        }
    },
    error => {
        console.log('err' + error) // for debug
        // Message({
        //     message: error.message,
        //     type: 'error',
        //     duration: 5 * 1000
        // })
        ELEMENT.Message({
            message: error.message,
            type: 'error',
            duration: 5 * 1000
        })
        return Promise.reject(error)
    }
)
