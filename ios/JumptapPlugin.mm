#import "JumpTapPlugin.h"
#import "JSONKit.h"


@implementation JumpTapPlugin

// The plugin must call super dealloc.
- (void) dealloc {
	self.publisherId = nil;
	self.widget = nil;

	[super dealloc];
}

// The plugin must call super init.
- (id) init {
	self = [super init];
	if (!self) {
		return nil;
	}

	self.publisherId = nil;
	self.widget = nil;

	return self;
}

- (NSString *) publisherId: (id) theWidget {
	return self.publisherId;
}

- (void) initializeWithManifest:(NSDictionary *)manifest appDelegate:(TeaLeafAppDelegate *)appDelegate {
	@try {
		NSDictionary *ios = [manifest valueForKey:@"ios"];
		NSString *jumpTapPublisherId = [ios valueForKey:@"jumpTapPublisherId"];

		self.publisherId = jumpTapPublisherId;

		self.widget = [[[JTAdWidget alloc] initWithDelegate:self shouldStartLoading:YES] autorelease];

		[JTAdWidget initializeAdService:FALSE];

		NSLog(@"{jumpTap} Initialized with manifest jumpTapPublisherId: '%@'", jumpTapPublisherId);
	}
	@catch (NSException *exception) {
		NSLog(@"{jumpTap} Failure to get jumpTapPublisherId key from manifest file: %@", exception);
	}
}

@end
