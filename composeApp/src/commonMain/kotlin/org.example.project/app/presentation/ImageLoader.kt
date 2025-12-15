package org.example.project.app.presentation

import coil3.ImageLoader
import coil3.PlatformContext
import coil3.disk.DiskCache
import coil3.memory.MemoryCache
import coil3.request.CachePolicy
import coil3.request.crossfade
import okio.FileSystem

fun asyncImageLoader(context: PlatformContext): ImageLoader {
    return ImageLoader.Builder(context)
        .networkCachePolicy(CachePolicy.ENABLED)
        .memoryCachePolicy(CachePolicy.ENABLED)
        .diskCachePolicy(CachePolicy.ENABLED)
        .memoryCache(memoryCache(context))
        .diskCache(diskCache())
        .crossfade(true)
        .build()
}

private fun diskCache(): DiskCache {
    return DiskCache.Builder()
        .directory(FileSystem.SYSTEM_TEMPORARY_DIRECTORY / "image_cache")
        .maxSizeBytes(1024 * 1024)
        .build()
}

private fun memoryCache(context: PlatformContext): MemoryCache {
    return MemoryCache.Builder()
        .maxSizePercent(context)
        .strongReferencesEnabled(enable = true)
        .build()
}