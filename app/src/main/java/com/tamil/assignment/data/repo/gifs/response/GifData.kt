package com.tamil.assignment.data.repo.gifs.response

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class GifData(
    val bitly_gif_url: String?,
    val bitly_url: String?,
    val caption: String?,
    val content_url: String?,
    val embed_url: String?,
    val fixed_height_downsampled_height: String?,
    val fixed_height_downsampled_url: String?,
    val fixed_height_downsampled_width: String?,
    val fixed_height_small_height: String?,
    val fixed_height_small_still_url: String?,
    val fixed_height_small_url: String?,
    val fixed_height_small_width: String?,
    val fixed_width_downsampled_height: String?,
    val fixed_width_downsampled_url: String?,
    val fixed_width_downsampled_width: String?,
    val fixed_width_small_height: String?,
    val fixed_width_small_still_url: String?,
    val fixed_width_small_url: String?,
    val fixed_width_small_width: String?,
    val id: String?,
    val image_frames: String?,
    val image_height: String?,
    val image_mp4_url: String?,
    val image_original_url: String?,
    val image_url: String?,
    val image_width: String?,
    val images: Images?,
    val import_datetime: String?,
    val is_sticker: Int?,
    val rating: String?,
    val slug: String?,
    val source: String?,
    val source_post_url: String?,
    val source_tld: String?,
    val title: String?,
    val trending_datetime: String?,
    val type: String?,
    val url: String?,
    val user: User?,
    val username: String?
) : Parcelable {
    @Parcelize
    data class Images(
        val wStill: WStill?,
        val downsized: Downsized?,
        val downsized_large: DownsizedLarge?,
        val downsized_medium: DownsizedMedium?,
        val downsized_small: DownsizedSmall?,
        val downsized_still: DownsizedStill?,
        val fixed_height: FixedHeight?,
        val fixed_height_downsampled: FixedHeightDownsampled?,
        val fixed_height_small: FixedHeightSmall?,
        val fixed_height_small_still: FixedHeightSmallStill?,
        val fixed_height_still: FixedHeightStill?,
        val fixed_width: FixedWidth?,
        val fixed_width_downsampled: FixedWidthDownsampled?,
        val fixed_width_small: FixedWidthSmall?,
        val fixed_width_small_still: FixedWidthSmallStill?,
        val fixed_width_still: FixedWidthStill?,
        val looping: Looping?,
        val original: Original?,
        val original_mp4: OriginalMp4?,
        val original_still: OriginalStill?,
        val preview: Preview?,
        val preview_gif: PreviewGif?,
        val preview_webp: PreviewWebp?
    ) : Parcelable {
        @Parcelize
        data class WStill(
            val height: String?,
            val url: String?,
            val width: String?
        ) : Parcelable

        @Parcelize
        data class Downsized(
            val height: String?,
            val size: String?,
            val url: String?,
            val width: String?
        ) : Parcelable

        @Parcelize
        data class DownsizedLarge(
            val height: String?,
            val size: String?,
            val url: String?,
            val width: String?
        ) : Parcelable

        @Parcelize
        data class DownsizedMedium(
            val height: String?,
            val size: String?,
            val url: String?,
            val width: String?
        ) : Parcelable

        @Parcelize
        data class DownsizedSmall(
            val height: String?,
            val mp4: String?,
            val mp4_size: String?,
            val width: String?
        ) : Parcelable

        @Parcelize
        data class DownsizedStill(
            val height: String?,
            val size: String?,
            val url: String?,
            val width: String?
        ) : Parcelable

        @Parcelize
        data class FixedHeight(
            val height: String?,
            val mp4: String?,
            val mp4_size: String?,
            val size: String?,
            val url: String?,
            val webp: String?,
            val webp_size: String?,
            val width: String?
        ) : Parcelable

        @Parcelize
        data class FixedHeightDownsampled(
            val height: String?,
            val size: String?,
            val url: String?,
            val webp: String?,
            val webp_size: String?,
            val width: String?
        ) : Parcelable

        @Parcelize
        data class FixedHeightSmall(
            val height: String?,
            val mp4: String?,
            val mp4_size: String?,
            val size: String?,
            val url: String?,
            val webp: String?,
            val webp_size: String?,
            val width: String?
        ) : Parcelable

        @Parcelize
        data class FixedHeightSmallStill(
            val height: String?,
            val size: String?,
            val url: String?,
            val width: String?
        ) : Parcelable

        @Parcelize
        data class FixedHeightStill(
            val height: String?,
            val size: String?,
            val url: String?,
            val width: String?
        ) : Parcelable

        @Parcelize
        data class FixedWidth(
            val height: String?,
            val mp4: String?,
            val mp4_size: String?,
            val size: String?,
            val url: String?,
            val webp: String?,
            val webp_size: String?,
            val width: String?
        ) : Parcelable

        @Parcelize
        data class FixedWidthDownsampled(
            val height: String?,
            val size: String?,
            val url: String?,
            val webp: String?,
            val webp_size: String?,
            val width: String?
        ) : Parcelable

        @Parcelize
        data class FixedWidthSmall(
            val height: String?,
            val mp4: String?,
            val mp4_size: String?,
            val size: String?,
            val url: String?,
            val webp: String?,
            val webp_size: String?,
            val width: String?
        ) : Parcelable

        @Parcelize
        data class FixedWidthSmallStill(
            val height: String?,
            val size: String?,
            val url: String?,
            val width: String?
        ) : Parcelable

        @Parcelize
        data class FixedWidthStill(
            val height: String?,
            val size: String?,
            val url: String?,
            val width: String?
        ) : Parcelable

        @Parcelize
        data class Looping(
            val mp4: String?,
            val mp4_size: String?
        ) : Parcelable

        @Parcelize
        data class Original(
            val frames: String?,
            val hash: String?,
            val height: String?,
            val mp4: String?,
            val mp4_size: String?,
            val size: String?,
            val url: String?,
            val webp: String?,
            val webp_size: String?,
            val width: String?
        ) : Parcelable

        @Parcelize
        data class OriginalMp4(
            val height: String?,
            val mp4: String?,
            val mp4_size: String?,
            val width: String?
        ) : Parcelable

        @Parcelize
        data class OriginalStill(
            val height: String?,
            val size: String?,
            val url: String?,
            val width: String?
        ) : Parcelable

        @Parcelize
        data class Preview(
            val height: String?,
            val mp4: String?,
            val mp4_size: String?,
            val width: String?
        ) : Parcelable

        @Parcelize
        data class PreviewGif(
            val height: String?,
            val size: String?,
            val url: String?,
            val width: String?
        ) : Parcelable

        @Parcelize
        data class PreviewWebp(
            val height: String?,
            val size: String?,
            val url: String?,
            val width: String?
        ) : Parcelable
    }

    @Parcelize
    data class User(
        val avatar_url: String?,
        val banner_image: String?,
        val banner_url: String?,
        val display_name: String?,
        val is_verified: Boolean?,
        val profile_url: String?,
        val username: String?
    ) : Parcelable
}