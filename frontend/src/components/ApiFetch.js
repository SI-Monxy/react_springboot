import React, { useState, useEffect } from 'react'
// import axios from 'axios'
const ApiFetch = () => {

    const [posts, setPosts] = useState([])

    useEffect(() => {
        // axios.get("https://jsonplaceholder.typicode.com/posts")
        //     .then(res => {
        //         setPosts(res.data)
        //     })

        fetch("https://jsonplaceholder.typicode.com/posts", { method: "GET" })
            // fetchの場合、htmlで返ってくるのでjson形式に変換する必要がある
            .then(res => res.json())
            .then(data => {
                setPosts(data)
            })
    }, [])

    return (
        <div>
            <ul>
                {
                    posts.map(post => <li key={post.id}>{post.title}</li>)
                }
            </ul>
        </div>
    )
}

export default ApiFetch