package com.example.QR;


import com.example.zxing.PlanarYUVLuminanceSource;
import com.google.zxing.*;
import com.google.zxing.common.HybridBinarizer;
import com.google.zxing.qrcode.QRCodeReader;


public class QRReader
{
	// QR読み込んだ結果を保持
	private static QRResult mQRResult = new QRResult();
	// QRコードの読み込みに成功したかどうか
	private static boolean mFoundFlag = false;

	// YUVオブジェクトのバイナリデータを読み込み、マーカーを検知
	public void readYUV( final byte[] data, int dataWidth, int dataHeight,
							   int left, int top, int width, int height, boolean reserversion ) {
		final LuminanceSource source = new PlanarYUVLuminanceSource( data,
				dataWidth,
				dataHeight, left, top, width, height, reserversion );

		final BinaryBitmap binaryBitmap = new BinaryBitmap( new HybridBinarizer(
				source ) );
		// final Reader reader = new MultiFormatReader();
		final Reader reader = new QRCodeReader();
		try {
			// 結果をゲット
			mQRResult.setResultData( reader.decode( binaryBitmap ) );
			mFoundFlag = true;
		}
		// 見つからなかった！
		catch ( NotFoundException ex ) {
			ex.printStackTrace();
			mFoundFlag = false;
		}
		catch ( ChecksumException ex ) {
			ex.printStackTrace();
			mFoundFlag = false;
		}
		catch ( FormatException ex ) {
			ex.printStackTrace();
			mFoundFlag = false;
		}
	}

	public static boolean isFound() {
		return mFoundFlag;
	}

	public static QRResult getQRResult() {
		return mQRResult;
	}

}
